package org.yeesoft.plutus.toolkit.dev;

import java.io.*;
import java.util.List;

/**
 * User: Yee
 * Date: 13-9-1
 * Time: 上午11:15
 */
public class Utils {
    public static BufferedWriter getBWWithBom(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        final byte[] bom = new byte[] { (byte)0xEF, (byte)0xBB, (byte)0xBF };
        FileOutputStream fos = new FileOutputStream(filePath);
        fos.write(bom);
        return new BufferedWriter(new OutputStreamWriter(fos,  "utf-8"));
    }

    public static BufferedWriter getBW(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        return new BufferedWriter(osw);
    }

    public static BufferedReader getBR(String filePath) throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
    }

    public static String firstLower(String s) {
        return s.substring(0,1).toLowerCase() + s.substring(1);
    }

    public static String firstUpper(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    public static String getBasePackage() {
        return "org.yeesoft.plutus";
    }

    public static String getBaseDir() {
        return System.getProperty("user.dir");
    }

    public static String getCppDir() {
        return getBaseDir() + "/generated-code/cpp/";
    }

    public static String getResourceDir() {
        return getBaseDir() + "/dev-toolkit/src/main/resources/";
    }

    public static String getJavaDir() {
        return getBaseDir() + "/generated-code/java/";
    }

    public static String trimSymbol(String s) {
        return s.replace("(","").replace("{", "").replace(",", "")
                .replace(")", "").replace("}","")
                .replace("{", "").replace(";", "").trim();
    }

    public static String trimSlash(String s) {
        return s.replace("/", "");
    }

    public static String trimEnter(String s) {
        return s.replace("\n", "").replace("\r", "");
    }

    public static String package2path(String p) {
        return p.replaceAll("\\.", "/") + "/";
    }


    public static String trimAll(String s) {
        return trimSymbol(trimSlash(trimEnter(s)));
    }

    public static String cppVar2JavaVar(String s) {
        //指针变量
        if (s.startsWith("*")) {
            //such as: *pUserLogout --> userLogout
            return firstLower(s.substring(2));
        } else {
            //such as: nRequestID --> requestID
            return firstLower(s.substring(1));
        }
    }

    public static String getPackageDir() {
        return getJavaDir() + getBasePackage().replaceAll("\\.", "/") + "/";
    }

    public static String ctype2jtype(String ctype) {
        String jtype;
        if (ctype.equals("char")) {
            jtype = "String";
        } else if (ctype.equals("long") || ctype.equals("int")) {
            jtype = ctype;
        } else if (ctype.equals("double") || ctype.equals("float")) {
            jtype = "double";
        } else if (ctype.equals("short")) {
            jtype = "int";
        } else if (ctype.equals("bool")) {
            jtype = "boolean";
        } else if (ctype.startsWith("CThostFtdc")) {
            jtype = ctype.replace("CThostFtdc", "")
                    .replace("Field", "").trim();
        } else if (ctype.equals("void")) {
            jtype = "void";
        }
        else {
            jtype = "UNKNOWN";
        }

        return jtype;
    }

    public static String ctype2JNIType(String ctype) {
        String jtype;
        if (ctype.equals("char")) {
            jtype = "jstring";
        } else if (ctype.equals("long") || ctype.equals("int")) {
            jtype = "j" +  ctype;
        } else if (ctype.equals("double") || ctype.equals("float")) {
            jtype = "jdouble";
        } else if (ctype.equals("short")) {
            jtype = "jint ";
        } else if (ctype.equals("bool")) {
            jtype = "jboolean ";
        } else if (ctype.startsWith("CThostFtdc")) {
            jtype = "jbyteArray ";
        } else if (ctype.equals("void")) {
            jtype = "void ";
        }
        else {
            jtype = "UNKNOWN";
            return "NOT SUPPORT!\n" ;
        }

        return jtype;
    }

    public static String getJNIAlloc(String ctype, String varName) {
        String jtype;
        if (ctype.equals("char")) {
            return "jstring j" + varName + " = env->NewStringUTF(" + varName + ");\n";
        } else if (ctype.equals("long") || ctype.equals("int")) {
            jtype = "j" +  ctype +  " ";
            return  jtype + "j" + varName + " = " + varName + ";\n";
        } else if (ctype.equals("double") || ctype.equals("float")) {
            jtype = "double ";
            return  jtype + "j" + varName + " = " + varName + ";\n";
        } else if (ctype.equals("short")) {
            jtype = "jint ";
            return  jtype + "j" + varName + " = " + varName + ";\n";
        } else if (ctype.equals("bool")) {
            jtype = "jboolean ";
            return  jtype + "j" + varName + " = " + varName + ";\n";
        } else if (ctype.startsWith("CThostFtdc")) {
            jtype = "jbyteArray ";
            return "NOT SUPPORT!\n" ;
        } else if (ctype.equals("void")) {
            jtype = "jvoid ";
            return "NOT SUPPORT!\n" ;
        }
        else {
            jtype = "UNKNOWN";
            return "NOT SUPPORT!\n" ;
        }
    }

    public static boolean isListLast(List list, Object ele) {
        if (list.indexOf(ele) == list.size() - 1) {
            return true;
        }
        return false;
    }
}
