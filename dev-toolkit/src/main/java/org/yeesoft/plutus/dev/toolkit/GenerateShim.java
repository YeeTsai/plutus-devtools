package org.yeesoft.plutus.dev.toolkit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;

/**
 * User: Yee
 * Date: 13-6-28
 * Time: 下午4:48
 */
public class GenerateShim {

    private static List<Function> functions = new ArrayList();
    private static HashMap<String, Integer> callbackFunctionNames = new HashMap<>();

    public static void main(String[] args) throws Exception {

        functions.clear();
        callbackFunctionNames.clear();
        String mdSignature = "md.signature";
        generateCppCallback(mdSignature);
        String mdSpiFile = "ThostFtdcMdSpi.h";
        generateFunctionList(mdSpiFile);
        generateInterface("CTPMarketDataListener");
        generateJNICallback("CTPMarketDataCallback", "ctpMarketDataListener");
        generateShimFunctionCpp("CTPMarketDataShim");
        generateShimFunctionChh("CTPMarketDataShim");


        functions.clear();
        callbackFunctionNames.clear();
        String traderSignature = "trader.signature";
        generateCppCallback(traderSignature);
        String traderSpiFile = "ThostFtdcTraderSpi.h";
        generateFunctionList(traderSpiFile);
        generateInterface("CTPTraderListener");
        generateJNICallback("CTPTraderCallback", "ctpTraderListener");
        generateShimFunctionChh("CTPTraderShim");
        generateShimFunctionCpp("CTPTraderShim");
    }

    private static void generateShimFunctionChh(String className) throws Exception {
        String cppFile = Utils.getCppDir() + className + ".h";
        BufferedWriter bw = Utils.getBWWithBom(cppFile);
        StringBuffer sb = new StringBuffer();
        Map<String, String> includeList = new HashMap<>();

        //头文件包含
        for (Function f : functions) {
           for (Argument arg : f.getCallArgs()) {
               if (arg.getType().startsWith("CThostFtdc")) {
                   String includeString =  "#include \"serializer/protobuf/" +
                           arg.getType().substring(1) + "2Message.h\"\n";
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

        //函数定义
        for (Function f : functions) {
            for (String comment : f.getComments()) {
                sb.append(comment + "\n");
            }
            sb.append(f.getReturnType() + " " + f.getName() + "(");
            for (Argument arg : f.getCallArgs()) {
                sb.append(arg.getType() + " " + arg.getName());
                if (!Utils.isListLast(f.getCallArgs(), arg))
                    sb.append(", ");
            }
            sb.append(");\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void generateShimFunctionCpp(String className) throws Exception {
        String cppFile = Utils.getCppDir() + className + ".cpp";
        BufferedWriter bw = Utils.getBWWithBom(cppFile);
        StringBuffer sb = new StringBuffer();
        List<String> jniArgs = new ArrayList();
        for (Function f : functions) {
            jniArgs.clear();
            for (String comment : f.getComments()) {
                sb.append(comment + "\n");
            }
            sb.append(f.getReturnType() + " " + className + "::" + f.getName() + "(");
            for (Argument arg : f.getCallArgs()) {
                sb.append(arg.getType() + " " + arg.getName());
                if (!Utils.isListLast(f.getCallArgs(), arg))
                    sb.append(", ");
            }
            sb.append(")\n{\n");
            sb.append("\tatslog(LOGDEBUG, \"" + className + ": " + f.getName() + " callback!\\n\");\n");
            sb.append("\tjobject obj = getJavaObject();\n" +
                    "\tJNIEnv *env = JavaEnv::getCurrent();\n");
            int i = 0;
            for (Argument arg : f.getCallArgs()) {
                sb.append("\n");
                if (arg.getType().startsWith("CThostFtdc")) {
                    sb.append("\tstd::string message" + i + ";\n");
                    sb.append("\tjbyteArray jmessage" + i  + " = NULL;\n");

                    sb.append("\t if (" + arg.getName().replace("*", "") +
                        " != NULL ) {\n");
                    sb.append("\t#ifdef _DEBUG\n");
                    sb.append("\t\tlog"+ Utils.ctype2jtype(arg.getType()) +
                        "(" + arg.getName().replace("*", "") + ");\n");
                    sb.append("\t#endif\n");
                    sb.append("\t\tftdc::" + arg.getType() + "2Message");
                    sb.append("(" + arg.getName().replace("*", "") + ", message" + i + ");\n");
                    sb.append("\t\tjmessage" + i + " = env->NewByteArray(message"
                        + i + ".size());\n");
                    sb.append("\t\tenv->SetByteArrayRegion(jmessage" + i + ", 0, message" + i +
                        ".size(), (jbyte*)message" + i + ".data());\n");
                    sb.append("\t}\n");
                    jniArgs.add("jmessage" + i);
                    i++;

                } else {
                    sb.append("\t" + Utils.getJNIAlloc(arg.getType(), arg.getName()));
                    jniArgs.add("j" + arg.getName());
                }
            }
            Integer seq = callbackFunctionNames.get(Utils.firstLower(f.getName()));
            sb.append("\n\tenv->CallVoidMethod(obj, m_pMethodCache->getMethodID(" + seq
                    + ")");
            if (!jniArgs.isEmpty())
                sb.append(", ");
            for (String arg : jniArgs) {
                if (!Utils.isListLast(jniArgs, arg))
                    sb.append(arg + ", ");
                else
                    sb.append(arg);
            }
            sb.append(");\n\n");
            sb.append("\tjthrowable exception = env->ExceptionOccurred();\n");
            sb.append("\tif (exception) {\n");
            sb.append("\t\tjclass cls = env->GetObjectClass(exception);\n");
            sb.append("\t\tenv->ExceptionClear();\n");
            sb.append("\t\tjmethodID mid = env->GetMethodID(cls, \"toString\",\"()Ljava/lang/String;\");\n");
            sb.append("\t\tjstring msg = (jstring) env->CallObjectMethod(exception, mid);\n");
            sb.append("\t\tenv->ExceptionDescribe();\n");
            sb.append("\t\tatslog(LOGERROR, " + "\"" + className
                    + ": call method " + seq + " Error, Exception [ %s ]\\n\", env->GetStringUTFChars(msg, 0));\n");
            sb.append("\t}\n");

            int j = 0;
            for (Argument arg : f.getCallArgs()) {
                if(arg.getType().startsWith("CThostFtdc")) {
                    sb.append("\tenv->DeleteLocalRef(jmessage" + j +");\n");
                }

                if (arg.getType().equals("char")) {
                    sb.append("\tenv->ReleaseStringUTFChars(j" +
                    arg.getName() + ", env->GetStringUTFChars(j" + arg.getName() + ", 0));\n");
                }
                j++;
            }

            sb.append("}\n");
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void generateCppCallback(String signatureFileName) throws Exception {
        String signatureFile = Utils.getResourceDir() + signatureFileName;
        String cppFile = Utils.getCppDir() + signatureFileName + ".cpp";
        BufferedReader br = Utils.getBR(signatureFile);
        String currentLine = null;
        String prevLine = null;
        List<Function> cppFunctionList = new ArrayList();
        while ( (currentLine = br.readLine()) != null) {
            if (currentLine.contains("Signature: ")) { //Signature: ([B[BIZ)V
                Function function = new Function();
                String signature = currentLine.split(":")[1];
                if (prevLine != null) {
                    String returnType = prevLine.split(" ")[3];
                    function.setReturnType(returnType);
                    function.setFullName(prevLine);
                    String functionName = prevLine.split(" ")[4].split("\\(")[0];
                    function.setName(functionName);
                }
                function.setSignature(signature.trim());
                cppFunctionList.add(function);
            }

            prevLine = currentLine;
        }
        BufferedWriter bw = Utils.getBW(cppFile);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (Function f : cppFunctionList) {
            sb.append("//" + f.getFullName() + "\n");
            sb.append("{\"" +  f.getName() + "\",\"" + f.getSignature() + "\", "
                    + i + "}" );
            if (!Utils.isListLast(cppFunctionList, f))
                sb.append("," );
            sb.append("\n");
            callbackFunctionNames.put(f.getName(), i);
            i++;
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static void generateJNICallback(String className, String listenerName) throws Exception {
        String interfaceFile = Utils.getPackageDir() +  className + ".java";
        BufferedWriter bw = Utils.getBW(interfaceFile);
        StringBuffer isb = new StringBuffer();
        for (Function f : functions) {
            for (String comment : f.getComments()) {
                isb.append(comment + "\n");
            }
            isb.append("\t//only called by JNI!\n");

            isb.append("\tprivate " + Utils.ctype2jtype(f.getReturnType()) +
                    " " + Utils.firstLower(f.getName()) + "(");
            for (Argument arg : f.getCallArgs()) {
                if (arg.getType().startsWith("CThostFtdc")) {
                    isb.append("byte[] " + " "
                        + Utils.cppVar2JavaVar(arg.getName()) + "Message");
                } else {
                    isb.append(Utils.ctype2jtype(arg.getType()) + " "
                        + Utils.cppVar2JavaVar(arg.getName()));
                }
                if (!Utils.isListLast(f.getCallArgs(), arg)) {
                    isb.append(", ");
                }
            }
            isb.append(") {\n");
            isb.append("\t\tlogger.debug(\"" + f.getName() + " recevied!\\n\");\n");
            for (Argument arg : f.getCallArgs()) {
                if (arg.getType().startsWith("CThostFtdc")) {
                    isb.append("\t\t" + Utils.ctype2jtype(arg.getType()) + " "
                        + Utils.cppVar2JavaVar(arg.getName()) + " = null;\n");
                    isb.append("\t\tif (" + Utils.cppVar2JavaVar(arg.getName()) + "Message != null) {\n");
                    isb.append("\t\t\t" + Utils.cppVar2JavaVar(arg.getName()) + " = ");
                    isb.append("org.yeesoft.ftdc.serializer.protobuf." + Utils.ctype2jtype(arg.getType()) + "Serializer.\n");
                    isb.append("\t\t\tbyte2" + Utils.ctype2jtype(arg.getType()) + "(" +
                            Utils.cppVar2JavaVar(arg.getName()) + "Message);\n");
                    isb.append("\t\t\tlogger.debug(\"" +Utils.ctype2jtype(arg.getType()) +
                            ":\\n\"+" + Utils.cppVar2JavaVar(arg.getName()) +
                        ".toString());\n");
                    isb.append("\t\t}\n");
                }
            }

            isb.append("\t\t" + listenerName + "." + Utils.firstLower(f.getName()) + "(" );
            for (Argument arg : f.getCallArgs()) {
                isb.append(Utils.cppVar2JavaVar(arg.getName()));
                if (!Utils.isListLast(f.getCallArgs(), arg))
                    isb.append(", ");
            }
            isb.append(");\n\t}\n\n");
        }
        bw.write(isb.toString());
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
        String srcDir = Utils.getPackageDir() + "jni/";
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