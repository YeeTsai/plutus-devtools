package org.yeesoft.plutus.dev.toolkit;

import java.io.*;
import java.util.*;

/**
 * User: Yee
 * Date: 13-6-28
 * Time: 下午4:48
 */
public class GenerateJNI {

    private static List<Function> functions = new ArrayList();

    public static void main(String[] args) throws Exception {

        functions.clear();
        String mdApiFile = "ThostFtdcMdApi.h";
        generateFunctionList(mdApiFile);
        generateJNINativeJava("CTPMarketDataJNI");
        generateJNINativeCpp("CTPMarketDataJNI", "Java_org_yeesoft_jctp_md_CTPMarketDataJNI",
                "CThostFtdcMdApi");

        functions.clear();
        String tradeApiFile = "ThostFtdcTraderApi.h";
        generateFunctionList(tradeApiFile);
        generateJNINativeJava("CTPTraderJNI");
        generateJNINativeCpp("CTPTraderJNI", "Java_org_yeesoft_jctp_trader_CTPTraderJNI",
                "CThostFtdcTraderApi");
    }

    private static void generateJNINativeCpp(String className, String prefix, String apiName) throws Exception {
        String cppFile = Utils.getCppDir() + className + ".cpp";
        BufferedWriter bw = Utils.getBW(cppFile);
        StringBuffer sb = new StringBuffer();
        Map<String, String> includeList = new HashMap<>();

        //头文件包含
        for (Function f : functions) {
            for (Argument arg : f.getCallArgs()) {
                if (arg.getType().startsWith("CThostFtdc")) {
                    String includeString =  "#include \"serializer/protobuf/" +
                            arg.getType().substring(1) + "2Vo.h\"\n";
                    if (includeList.get(arg.getType()) == null) {
                        includeList.put(arg.getType(), includeString);
                    }
                }
            }
        }

        Iterator iter = includeList.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            sb.append(entry.getValue());
        }

        //函数
        String messageVar = null;
        for (Function f : functions) {
            for (String comment : f.getComments()) {
                sb.append(comment + "\n");
            }
            sb.append("JNIEXPORT ");
            sb.append(Utils.ctype2JNIType(f.getReturnType()) + " JNICALL " + prefix + "_" + Utils.firstLower(f.getName()) + "\n(");
            sb.append("JNIEnv *env, jobject obj");
            for (Argument arg : f.getCallArgs()) {
                String jniType = Utils.ctype2JNIType(arg.getType());
                sb.append("," + jniType + " ");
                if (jniType.contains("jbyteArray")) {
                    messageVar = Utils.cppVar2JavaVar(arg.getName())  + "Message";
                    sb.append(messageVar);
                }
                else {
                    sb.append(Utils.cppVar2JavaVar(arg.getName()));
                }
            }
            sb.append(")\n{\n");
            for (Argument arg : f.getCallArgs()) {
                if (arg.getName().equals("requestID")) {
                    sb.append("\tjctp::atslog(LOGINFO, \"" + className + ":" + f.getName() +
                            "id: %d\n\", requestID);");
                }
            }
            sb.append("\t" + apiName + "* userApi = reinterpret_cast<" +
                    apiName + "*>(get_apiHandle(env, obj, 1));\n");
            for (Argument arg : f.getCallArgs()) {
                String jniType = Utils.ctype2JNIType(arg.getType());
                if (jniType.contains("jbyteArray")) {
                    sb.append("\t" + arg.getType() + " " + Utils.cppVar2JavaVar(arg.getName()) + ";\n");
                    sb.append("\tif (" + messageVar + " != NULL) {\n");
                    sb.append("\t\tjsize len = env->GetArrayLength(" + messageVar + ");\n");
                    sb.append("\t\tjbyte* buf = (jbyte*)malloc(len * sizeof(jbyte));\n");
                    sb.append("\t\tenv->GetByteArrayRegion(" + messageVar + ", 0, len, buf);\n");
                    sb.append("\t\tftdc::" + Utils.firstUpper(Utils.ctype2jtype(arg.getType())) +
                        "Message2Struct((void *)buf, (int)len, " + "&" + Utils.cppVar2JavaVar(arg.getName()) + ");\n");
                    sb.append("\t\tfree(buf);\n");
                    sb.append("\t#ifdef _DEBUG\n");
                    sb.append("\t\tjctp::log" +
                            Utils.firstUpper(Utils.cppVar2JavaVar(arg.getName())).replace("Field", "")
                            + "(" + "&" + Utils.cppVar2JavaVar(arg.getName()) + ");\n");
                    sb.append("\t#endif\n");
                    sb.append("\t}\n");
                } else if (jniType.contains("jstring")) {
                    sb.append("\tconst char *c = NULL;\n");
                    sb.append("\tif (" + Utils.cppVar2JavaVar(arg.getName())  + " != NULL ) {\n");
                    sb.append("\t\tc = env->GetStringUTFChars(" + Utils.cppVar2JavaVar(arg.getName()) +
                        ",0);\n");
                    sb.append("\t}\n");
                }

            }

            if (f.getReturnType().equals("int")) {
                sb.append("\tint ret = ");
                sb.append("userApi->" + f.getName() + "(");
            } else {
                sb.append("\tuserApi->" + f.getName() + "(");
            }


            for (Argument arg : f.getCallArgs()) {
                String jniType = Utils.ctype2JNIType(arg.getType());
                if (jniType.contains("jbyteArray")) {
                    sb.append("&" + Utils.cppVar2JavaVar(arg.getName()));
                } else if (jniType.equals("jstring")) {
                    sb.append("c");
                } else {
                    sb.append(Utils.cppVar2JavaVar(arg.getName()));
                }
                if (!Utils.isListLast(f.getCallArgs(), arg))
                    sb.append(", ");
            }

            sb.append(");\n");
            sb.append("\tjctp::atslog(LOGINFO, \"" + className + ":" + f.getName() +
                    " OK!\\n\");\n");

            if (f.getReturnType().equals("int")) {
                sb.append("\treturn ret;\n");
            }

            sb.append("}\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void generateJNINativeJava(String className) throws Exception {
        String nativeFile = Utils.getPackageDir() +  className + ".java";
        BufferedWriter bw = Utils.getBW(nativeFile);
        StringBuffer nsb = new StringBuffer();
        nsb.append("package " + Utils.getBasePackage() + ";\n");
        nsb.append("public class " + className + "{\n");
        for (Function f : functions) {
            nsb.append("\n");
            for (String comment : f.getComments()) {
                nsb.append(comment + "\n");
            }

            //wrapper for google protocol buffer converter
            boolean hasByteArray=false;
            for (Argument arg : f.getCallArgs()) {
                if (arg.getType().startsWith("CThostFtdc")) {
                    hasByteArray = true;
                }
            }

            String messageVar = null;
            String byteVarName = null;
            String byteTypeName = null;
            if (hasByteArray) {
                nsb.append("\tprivate ");
            } else {
                nsb.append("\tpublic ");
            }
            nsb.append("native " + Utils.ctype2jtype(f.getReturnType()) +
                    " " + Utils.firstLower(f.getName()) + "(");
            for (Argument arg : f.getCallArgs()) {
                if (arg.getType().startsWith("CThostFtdc")) {
                    byteVarName = Utils.cppVar2JavaVar(arg.getName());
                    byteTypeName = Utils.ctype2jtype(arg.getType());
                    messageVar = byteVarName + "Message ";
                    nsb.append("byte[] " + messageVar);
                }
                else {
                    nsb.append(Utils.ctype2jtype(arg.getType()) + " "
                            + Utils.cppVar2JavaVar(arg.getName()) + " ");
                }
                if (!Utils.isListLast(f.getCallArgs(), arg))
                    nsb.append(", ");
            }
            nsb.append(");\n");
            if (hasByteArray) {
                nsb.append("\t//wrapper for google protocol buffer converter.\n");
                nsb.append("\tpublic " + Utils.ctype2jtype(f.getReturnType()) +
                        " " + Utils.firstLower(f.getName()) + "(");
                for (Argument arg : f.getCallArgs()) {
                    if (arg.getType().startsWith("CThostFtdc")) {
                        nsb.append(Utils.ctype2jtype(arg.getType()) + " "
                            + byteVarName + " ");
                    } else {
                        nsb.append(Utils.ctype2jtype(arg.getType())  +
                                " " + Utils.cppVar2JavaVar(arg.getName()));
                    }
                    if (!Utils.isListLast(f.getCallArgs(), arg))
                        nsb.append(", ");
                }
                nsb.append(") {\n");
                nsb.append("\t\tbyte[] " + messageVar + "= null;\n");
                nsb.append("\t\tif (" + byteVarName + " != null) {\n");

                nsb.append("\t\t\tlogger.debug(\"" + Utils.firstUpper(byteVarName)  +
                        ":\\n\"+" + byteVarName + ".toString());\n");
                nsb.append("\t\t\t" + messageVar + " = \n");
                nsb.append("\t\t\t\torg.yeesoft.ftdc.serializer.protobuf." + byteTypeName + "Serializer." +
                    Utils.firstLower(byteTypeName) + "2Message(" + byteVarName + ");\n\t\t}\n");
                if (!f.getReturnType().equals("void")) {
                    nsb.append("\t\treturn ");
                } else {
                    nsb.append("\t\t");
                }
                nsb.append(Utils.firstLower(f.getName()) + "(");
                for (Argument arg : f.getCallArgs()) {
                    if (arg.getType().startsWith("CThostFtdc")) {
                        nsb.append(messageVar);
                    } else {
                        nsb.append(Utils.cppVar2JavaVar(arg.getName()));
                    }
                    if (!Utils.isListLast(f.getCallArgs(), arg))
                        nsb.append(", ");
                }
                nsb.append(");\n");
                nsb.append("\t}\n");
            }
        }
        bw.write(nsb.toString());
        bw.close();
    }

    private static void generateInterface(String className) throws Exception {
        String interfaceFile = Utils.getPackageDir() +  className + ".java";
        BufferedWriter bw = Utils.getBW(interfaceFile);
        StringBuffer isb = new StringBuffer();
        isb.append("package " + Utils.getBasePackage() + ";\n");
        isb.append("public interface " + className + " {\n");
        for (Function f : functions) {
            for (String comment : f.getComments()) {
                isb.append(comment + "\n");
            }

            isb.append("\tpublic " + Utils.ctype2jtype(f.getReturnType()) +
                    " " + Utils.firstLower(f.getName()) + "(");
            for (Argument arg : f.getCallArgs()) {
                isb.append(Utils.ctype2jtype(arg.getType()) + " "
                        + Utils.cppVar2JavaVar(arg.getName()));
                if (!Utils.isListLast(f.getCallArgs(), arg))
                    isb.append(", ");
            }
            isb.append(");\n");
        }
        bw.write(isb.toString());
        bw.close();
    }

    private static void generateFunctionList(String fileName) throws Exception {
        String spiPath = Utils.getResourceDir() + fileName;

        //native
        BufferedReader spiReader = Utils.getBR(spiPath);

        String currentLine;
        String[] lines = new String[1024]; //最大支持1024行

        int lineNum = 1;
        while ( (currentLine = spiReader.readLine()) != null) {
            lines[lineNum] = currentLine;
            if (currentLine.contains("virtual ")) { //需要处理的函数
                Function function = new Function();
                int commentNum = 0;
                for (int i = lineNum-1; i>0; i--) {
                    if (lines[i].contains("//")) {
                        commentNum++;
                    } else {
                        break;
                    }
                }
                for (int j= lineNum - commentNum; j<lineNum; j++) {
                    function.addComment(lines[j]);
                }

                String[] signatures = currentLine.split(" ");
                function.setReturnType(signatures[1]);

                if (signatures.length < 4) { //没有参数的情况
                   //Such as: virtual void OnFrontConnected(){};
                    function.setName(Utils.trimSymbol(signatures[2]));
                } else { //有参数
                    //Such as: virtual void OnRspUserLogout(CThostFtdcUserLogoutField *pUserLogout, CThostFtdcRspInfoField *pRspInfo, int nRequestID, bool bIsLast)
                    String[] nameAndArgs = signatures[2].split("\\(") ;
                    function.setName(Utils.trimSymbol(nameAndArgs[0]));
                    Argument argument = new Argument();
                    argument.setType(nameAndArgs[1]);
                    argument.setName(Utils.trimSymbol(signatures[3]));
                    function.addCallArg(argument);

                    //剩余其它参数
                    for (int i=4; i<signatures.length-1; i=i+2) {
                        Argument arg = new Argument();
                        arg.setType(signatures[i]);
                        arg.setName(Utils.trimSymbol(signatures[i+1]));
                        function.addCallArg(arg);
                    }
                }
                functions.add(function);
            }
            lineNum++;
        }
    }
}