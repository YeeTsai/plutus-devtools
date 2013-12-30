package org.yeesoft.plutus.dev.toolkit;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeneratePackage {
    private static String baseDir;
    private static String resourceDir;
    private static String ftdcPackageDir;
    private static String jctpPackageDir;
    private static String ftdcBasePackage;
    private static String jctpBasePackage;
    private static String cppDir;
    private static String javaDir;
    private static String protosDir;
    private static String javaProtosDir;
    private static String javaSerializerDir;
    private static String cppProtosDir;
    private static String sqlDir;
    private static String cppSerializerDir;
    private static List<Struct> structList = new ArrayList();
    private static String structFile;
    private static String typeFile;

    public static void main(String[] args) throws Exception {
        baseDir = System.getProperty("user.dir");
        resourceDir = baseDir + "/dev-toolkit/src/main/resources/";

        ftdcBasePackage = "org.yeesoft.ftdc";
        jctpBasePackage = "org.yeesoft.jctp";

        protosDir = baseDir + "/generated-code/protos/";

        javaDir = baseDir + "/generated-code/java/";
        ftdcPackageDir = javaDir + Utils.package2path(ftdcBasePackage);
        jctpPackageDir = javaDir + Utils.package2path(jctpBasePackage);
        javaSerializerDir = ftdcPackageDir + "serializer/protobuf/";
        javaProtosDir = javaSerializerDir + "protos/";

        cppDir = baseDir + "/generated-code/cpp/";
        cppSerializerDir = cppDir + "serializer/protobuf/";
        cppProtosDir = cppSerializerDir + "protos/";

        sqlDir = baseDir + "/generated-code/sql/";

        structFile = resourceDir + "ThostFtdcUserApiStruct.h";
        typeFile = resourceDir + "ThostFtdcUserApiDataType.h";

        structList.clear();
        generateStructList(args);

        if (structList.isEmpty()) {
            System.out.println("NO Struct!!");
            System.exit(1);
        }

        System.out.println("Find " + structList.size() + " structs!");

/*        for (Struct struct : structList) {
            System.out.println(" start generate " + struct.getComment() + " "
                + struct.getStructName() + "'s code..");
            generateCode(struct);
        }
        generateLogStructCpp(structList);
       */
        generateDBSchema(structList);
        generateInsertSQL(structList);
    }

    private static void generateStructList(String structs[]) throws Exception{

        //当指定struct名称时，生成指定名称的代码，否则生成全部代码
        if (structs.length > 0) {
            for (String structName : structs) {
                getStruct(structName);
            }
        } else {
            getStruct(null);
        }

    }

    private static void getStruct(String structName) throws Exception{
        BufferedReader structReader = getBR(structFile);
        String currentLine;
        String prevLine = null;
        String fullStructName;
        String exceptStruct = null;
        if (structName == null) {
            exceptStruct = "struct ";
        } else {
            exceptStruct = "struct " + structName;
        }
        while ( (currentLine = structReader.readLine()) != null) {
            if (currentLine.startsWith(exceptStruct)) {
                fullStructName = currentLine;
                Struct struct = new Struct();
                struct.setFullStructName(fullStructName);
                if (prevLine != null)
                    struct.setComment(prevLine);
                structList.add(struct);
            }

            prevLine = currentLine;
        }
    }

    private static void generateCode(Struct struct) throws Exception {

        //根据头文件将该结构字段进行整理
        generateFieldList(struct);

        //根据FieldList生成代码文件

        //Google Protocol Buffer描述文件 .protos
        generateGoogleProtocolBuffer(struct);

        //编译proto文件
        compileProtos(struct);

        //c++ struct 转换为 GPB类
        generate2MessageCpp(struct);

        //c++ GPB类转换为struct
        generate2StructCpp(struct);

        //java POJO值类
        generateVOJava(struct);

        //java POJO值类与GPB类的相互转换
        generateSerializerJava(struct);
    }

    private static void generateFieldList(Struct struct) throws IOException {
        String line;
        boolean started = false;
        boolean finded = false;
        boolean ended = false;
        String structName = struct.getFullStructName();
        List<Field> fields = new ArrayList<Field>();

        List<String> contents = new ArrayList();
        Map<String, Type> typeMap = new HashMap();

        BufferedReader typeReader = getBR(typeFile);
        while ( (line = typeReader.readLine()) != null) {
            if (line.startsWith("typedef")) {
                String[] content = line.split(" ");
                String ctype = content[1];
                String[] name_all = content[2].split("\\[");
                int length = 0;
                if (name_all.length == 2) {
                    String lengthString = name_all[1].replace(']', ' ').replace(';', ' ').trim();
                    length = Integer.parseInt(lengthString);

                } else {
                    length = 0;
                }
                String name = name_all[0].replace(';', ' ').trim();
                Type type = new Type();
                type.setCtype(ctype);
                type.setName(name);
                type.setLength(length);
                typeMap.put(name, type);
            }
        }

        BufferedReader structReader = getBR(structFile);

        while ( (line = structReader.readLine()) != null) {
            if (line.contentEquals(structName)) {
                finded = true;
            }

            if (line.contentEquals("{") && finded) {
                started = true;
                continue;
            }

            if (line.contentEquals("};") && started) {
                ended = true;
                break;
            }

            if (started && ! ended) {
                contents.add(line);
            }
        }

        Field field = null;
        for (String content : contents) {
            if (content.contains("//")) {
                field = new Field();
                field.setComment(content);
            } else {
                String[] contentField = content.split("\t");
                String fieldName;
                String typeName;
                Type type;
                if (contentField.length == 3) {
                    fieldName = contentField[2];
                    typeName = contentField[1];
                } else {
                    fieldName = contentField[1];
                    typeName = contentField[0];
                }
                field.setName(fieldName.replace(';', ' ').trim());
                type = typeMap.get(typeName);
                if (type == null) {
                    System.out.println("ERROR: typeName: " + typeName + " not found type!");
                    System.exit(1);
                }
                field.setType(type);
                fields.add(field);
            }
        }

        if (fields.size() == 0) {
            System.out.println("未查找到对应结构!");
            System.out.println("struct Name: " + structName);
            System.out.println("struct File: " + structFile);
            System.out.println("type File: " + typeFile);
        } else {
            struct.setFields(fields);
        }
    }

    private static void generateGoogleProtocolBuffer(Struct struct) throws Exception {
        String protoClassName = struct.getProtoClassName();
        String messageName = struct.getMessageName();
        String gpbFile = protosDir + struct.getProtoFileName();
        BufferedWriter bfw = getBW(gpbFile);
        StringBuffer sbf = new StringBuffer();
        sbf.append("package ftdc;\n");
        sbf.append("// " + struct.getComment() + "\n");
        sbf.append("option java_package = \"" + ftdcBasePackage + ".serializer.protobuf.protos\";\n");
        sbf.append("option java_outer_classname = \"" + protoClassName + "\";\n");
        sbf.append("message " + messageName + " {\n");
        int sequence = 1;
        for (Field field : struct.getFields()) {
            String typeString;
            String ctype = field.getType().getCtype();
            if (ctype.contentEquals("char")) {
                typeString = "string";
            } else if (ctype.contentEquals("int") || ctype.contentEquals("short")) {
                typeString = "int32";
            } else if (ctype.contentEquals("double")) {
                typeString = "double";
            } else if (ctype.contentEquals("long")) {
                typeString = "int32";
            } else {
                typeString = "UNKNOWN";
            }
            sbf.append("optional " + typeString + " " + field.getLowercaseFirstName()
                    + " = " + sequence + "; //" + field.getComment() + "\n");
            sequence++;
        }
        sbf.append("}\n");
        bfw.write(sbf.toString());
        bfw.close();
    }

    private static void compileProtos(Struct struct) throws IOException {
        String sep = " ";
        String tools = "D:\\Tools\\protoc.exe";
        String protoPath = "--proto_path=" + protosDir;
        String cppOut = "--cpp_out=" + cppProtosDir;
        String javaOut = "--java_out=" + javaDir;
        String protoName = protosDir + struct.getProtoFileName();
        String command = tools + sep + protoPath + sep +
                cppOut + sep + javaOut + sep + protoName;

        File file = new File(cppProtosDir);
        if (!file.exists()) {
            file.mkdirs();
        }

        System.out.println("start compile protos:");
        System.out.println("\t" + command);
        Runtime.getRuntime().exec(command);

    }

    private static void generateInsertSQL(List<Struct> structs) throws Exception {
        String baseLogFileName = "FtdcInsert";
        String sqlFile = sqlDir + baseLogFileName + ".sql";
        BufferedWriter hbw = getBW(sqlFile);
        StringBuffer hsb = new StringBuffer();
        for (Struct struct : structs) {
            String tableName = struct.getBaseName();
            hsb.append("insert into " + tableName + " values (?,");
            generateFieldList(struct);
            for (Field field : struct.getFields()) {
                hsb.append("?");
                if (!Utils.isListLast(struct.getFields(), field)) {
                    hsb.append(",");
                }
            }
            hsb.append(");\n");
            hsb.append("result = H2DBUtil.update(runner, connection, insertSQL, ");
            for (Field field : struct.getFields()) {
                hsb.append(Utils.firstLower(tableName) + ".get" + field.getName() + "()");
                if (!Utils.isListLast(struct.getFields(), field)) {
                    hsb.append(",");
                }
            }
            hsb.append(");\n");
        }
        hbw.write(hsb.toString());

        hbw.close();
    }

    private static void generateDBSchema(List<Struct> structs) throws Exception {
        String baseLogFileName = "FtdcSchema";
        String sqlFile = sqlDir + baseLogFileName + ".sql";
        BufferedWriter hbw = getBW(sqlFile);
        StringBuffer hsb = new StringBuffer();
        for (Struct struct : structs) {
            String tableName = struct.getBaseName();
            hsb.append("create table if not exists " + tableName + "\n(\n");
            hsb.append("\tid    char(8) not null, --UUID\n");
            generateFieldList(struct);
            for (Field field : struct.getFields()) {
                String ctype = field.getType().getCtype();
                if (ctype.equals("char")) {
                    if (field.getType().getLength() == 0) { //char
                        hsb.append("\t" + field.getName() + " char(1)");
                    } else { //char[]
                        hsb.append("\t" + field.getName() + " char(" + field.getType().length + ")");
                    }

                } else if (ctype.equals("double") || ctype.equals("float")) {
                    hsb.append("\t" + field.getName() + " double ");
                } else if (ctype.equals("int") || ctype.equals("short")) {
                    hsb.append("\t" + field.getName() + " int ");
                } else if (ctype.equals("long")) {
                    hsb.append("\t" + field.getName() + " bigint ");
                } else if (ctype.equals("bool")) {
                    hsb.append("\t" + field.getName() + " int ");
                }

                hsb.append(" not null");

                if (!Utils.isListLast(struct.getFields(), field)) {
                    hsb.append(",");
                }
                hsb.append("\t--" + field.getComment());
                hsb.append("\n");
            }
            hsb.append(");\n");

            //生成insert sql
        }
        hbw.write(hsb.toString());

        hbw.close();
    }

    private static void generateLogStructCpp(List<Struct> structs) throws Exception {
        String baseLogFileName = "FtdcStructLogger";
        String hFile = cppDir + baseLogFileName + ".h";
        String cppFile = cppDir + baseLogFileName +  ".cpp";
        BufferedWriter hbw = getBW(hFile);
        StringBuffer hsb = new StringBuffer();
        hsb.append("#include <string>\n");
        hsb.append("#include <sstream>\n");
        hsb.append("#include <iomanip>\n");
        hsb.append("#include <ctp/ThostFtdcUserApiStruct.h>\n");
        hsb.append("namespace jctp {\n");
        for (Struct struct : structs) {
            String functionName = "void log" + struct.getBaseName() +
                    "(" + struct.getStructName() + " *value);\n";
            hsb.append("\t" + functionName);
        }
        hsb.append("}\n");
        hbw.write(hsb.toString());
        hbw.close();

        BufferedWriter cbw = getBWWithBom(cppFile);
        StringBuffer csb = new StringBuffer();
        csb.append("#include \"util.h\"\n");
        csb.append("#include \"" + baseLogFileName + ".h\"\n");

        csb.append("namespace jctp {\n");
        for (Struct struct : structs) {
            generateFieldList(struct);
            String functionName = "void log" + struct.getBaseName() +
                    "(" + struct.getStructName() + " *value)";
            csb.append(functionName + "\n{\n");
            csb.append("\tatslog(LOGDEBUG, \"start print " + struct.getBaseName() + " struct...\\n\");\n");
            for (Field field : struct.getFields()) {
                String ctype = field.getType().getCtype();
                csb.append("\tatslog(LOGDEBUG, \"\\t" + field.getName() + " [ " + field.getComment() + " ]");
                if (ctype.equals("char")) {
                    if (field.getType().getLength() == 0) { //char
                        csb.append(": %c\\n\", value->" + field.getName() + ");\n");
                    } else { //char[]
                        csb.append(": %s\\n\", value->" + field.getName() + ");\n");
                    }
                } else if (ctype.equals("double") || ctype.equals("float")) {
                    csb.append(": %f\\n\", value->" + field.getName() + ");\n");
                } else if (ctype.equals("int") || ctype.equals("short")) {
                    csb.append(": %d\\n\", value->" + field.getName() + ");\n");
                } else if (ctype.equals("long")) {
                    csb.append(": %ld\\n\", value->" + field.getName() + ");\n");
                } else if (ctype.equals("bool")) {
                    csb.append(": %s\\n\", value->" + field.getName() + "?\"true\":\"false\");\n");
                }
            }
            csb.append("\tatslog(LOGDEBUG, \"end print " + struct.getBaseName() + " struct...\\n\");\n");
            csb.append("}\n");
        }
        csb.append("}\n");
        cbw.write(csb.toString());
        cbw.close();
    }

    private static void generate2MessageCpp(Struct struct) throws Exception {
        String baseFileName = struct.getCppFileBaseName() + "2Message";
        String hFile = cppSerializerDir + baseFileName + ".h";
        String cppFile = cppSerializerDir + baseFileName + ".cpp";
        BufferedWriter hbw = getBWWithBom(hFile);
        StringBuffer hsb = new StringBuffer();
        hsb.append("#include <string>\n");
        hsb.append("#include <sstream>\n");
        hsb.append("#include <iomanip>\n");
        hsb.append("#include <ctp/ThostFtdcUserApiStruct.h>\n");
        hsb.append("#include \"protos/" + struct.getCppFileBaseName() + ".pb.h\"\n");
        hsb.append("/*" + struct.getComment() + " */\n");
        hsb.append("namespace ftdc {\n");
        hsb.append("\tvoid " + struct.getStructName() + "2Message(const " +
                struct.getFullStructName() + " *source, \n\t\tstd::string &message); \n}\n" );

        hbw.write(hsb.toString());
        hbw.close();

        BufferedWriter cbw = getBWWithBom(cppFile);
        StringBuffer csb = new StringBuffer();
        csb.append("#include \"" + baseFileName + ".h\"\n");
        csb.append("/* " + struct.getComment() + " */\n");
        csb.append("namespace ftdc {\n");
        csb.append("\tvoid " + struct.getStructName() + "2Message(const " +
                struct.getFullStructName() + " *source, \n\t\tstd::string &message) {\n" );
        csb.append("\t\t\t" + struct.getMessageName() + " msg;\n");
        for (Field field : struct.getFields()) {
            if (field.getType().getCtype().equals("char") && field.getType().getLength() == 0) {
                csb.append("\t\t\tchar " + field.getName().toLowerCase() + "[2];\n");
                csb.append("\t\t\t" + field.getName().toLowerCase() + "[0]=");
                csb.append("source->" + field.getUpperFirstName() + ";\n");
                csb.append("\t\t\t" + field.getName().toLowerCase() + "[1]='\\0';\n");
                csb.append("\t\t\tmsg.set_" + field.getName().toLowerCase() + "(");
                csb.append(field.getName().toLowerCase());
            } else {
                csb.append("\t\t\tmsg.set_" + field.getName().toLowerCase() + "(");
                csb.append("source->" + field.getUpperFirstName());
            }
            csb.append("); /* " + field.getComment() + " */\n");
        }

        csb.append("\t\t\tmsg.SerializeToString(&message);\n\t}\n}\n");
        cbw.write(csb.toString());
        cbw.close();
    }

    private static void generate2StructCpp(Struct struct) throws Exception {
        String baseFileName = struct.getCppFileBaseName() + "2Vo";
        String hFile = cppSerializerDir + baseFileName + ".h";
        String cppFile = cppSerializerDir + baseFileName + ".cpp";
        BufferedWriter hbw = getBWWithBom(hFile);

        StringBuffer hsb = new StringBuffer();
        hsb.append("#include <string>\n");
        hsb.append("#include <sstream>\n");
        hsb.append("#include <iomanip>\n");
        hsb.append("#include <ctp/ThostFtdcUserApiStruct.h>\n");
        hsb.append("#include \"protos/" + struct.getCppFileBaseName() + ".pb.h\"\n\n");
        hsb.append("/* " + struct.getComment() + " */\n");
        hsb.append("namespace ftdc {\n");
        hsb.append("\tvoid " + struct.getMessageName() + "2Struct(const " +
                " void *buffer, int length, \n\t\t" + struct.getFullStructName() + " *target); \n}\n");

        hbw.write(hsb.toString());
        hbw.close();
        BufferedWriter cbw = getBWWithBom(cppFile);
        StringBuffer csb = new StringBuffer();
        csb.append("#include \"" + baseFileName + ".h\"\n");
        csb.append("/* " + struct.getComment() + " */\n");
        csb.append("namespace ftdc {\n");
        csb.append("\tvoid " + struct.getMessageName() + "2Struct(const " +
                " void *buffer, int length, \n\t\t" + struct.getFullStructName() +" *target) {\n" );
        csb.append("\t\t\t" + struct.getMessageName() + " msg;\n");
        csb.append("\t\t\tmsg.ParseFromArray(buffer, length);\n");
        for (Field field : struct.getFields()) {
            if (field.getType().getCtype().equals("char") ) {
                if (field.getType().getLength() == 0) {
                    csb.append("\t\t\ttarget->" + field.getUpperFirstName() + " = " +
                        "msg." + field.getName().toLowerCase() + "().c_str()[0]; ");
                } else {
                    csb.append("\t\t\tstrcpy(target->" + field.getUpperFirstName() +
                        ", msg." + field.getName().toLowerCase() + "().c_str()); ");
                }
            } else {
                csb.append("\t\t\ttarget->" + field.getUpperFirstName() + " = " +
                        "msg." + field.getName().toLowerCase() + "(); ");
            }
            csb.append( "/* " + field.getComment() + " */\n");
        }

        csb.append("\t}\n}\n");
        cbw.write(csb.toString());
        cbw.close();
    }

    private static String ctype2jtype(String ctype) {
        String jtype;
        if (ctype.equals("char")) {
            jtype = "String";
        } else if (ctype.equals("long") || ctype.equals("int")) {
            jtype = ctype;
        } else if (ctype.equals("double") || ctype.equals("float")) {
            jtype = "double";
        } else if (ctype.equals("short")) {
            jtype = "int";
        } else {
            jtype = "UNKNOWN";
        }

        return jtype;
    }

    private static void generateVOJava(Struct struct)
            throws Exception {
        String srcFile = ftdcPackageDir + struct.getVoClassName() + ".java";
        BufferedWriter bw = getBW(srcFile);
        StringBuffer sb = new StringBuffer();
        sb.append("package " + ftdcBasePackage + ";\n");
        sb.append("//" + struct.getComment() + "\n");
        sb.append("public class " + struct.getVoClassName() + "{\n");

        for (Field field : struct.getFields()) {
            String ctype = field.getType().getCtype().trim();
            String name = field.getLowercaseFirstName().trim();
            String comment = field.getComment();

            sb.append("\t\tprivate " + ctype2jtype(ctype) + " " + name + "; //" + comment + "\n");
        }

        for (Field field : struct.getFields()) {
            String ctype = field.getType().getCtype().trim();
            String name = field.getLowercaseFirstName().trim();
            String upperName = field.getUpperFirstName();
            String jtype = ctype2jtype(ctype);
            sb.append("\t\tpublic void set" + upperName + "(" + jtype + " " + name + ") {\n");
            sb.append("\t\t\tthis." + name + " = "  + name + ";\n\t\t}\n");
            sb.append("\t\tpublic " + jtype + " get" + upperName + "() {\n");
            sb.append("\t\t\treturn this." + name + ";\n\t\t}\n\n");
        }

        sb.append("\t\t@Override\n");
        sb.append("\t\tpublic String toString() {\n");
        sb.append("\t\t\tStringBuffer sb = new StringBuffer();\n");
        sb.append("\t\t\tsb.append(\"\\n\");\n");
        for (Field field : struct.getFields()) {
            sb.append("\t\t\tsb.append(\"" + field.getLowercaseFirstName() + " [ " + field.getComment() + " ] : \");\n");
            sb.append("\t\t\tsb.append(" + field.getLowercaseFirstName() + ");\n");
            sb.append("\t\t\tsb.append(\"\\n\");\n");
        }
        sb.append("\t\t\treturn sb.toString();\n");
        sb.append("\t\t}\n");

        sb.append("}\n");
        bw.write(sb.toString());
        bw.close();
    }

    private static void generateSerializerJava(Struct struct) throws Exception {
        String srcFile = javaSerializerDir + struct.getSerializerClassName() + ".java";
        BufferedWriter bw = getBW(srcFile);
        StringBuffer sb = new StringBuffer();
        sb.append("package " + ftdcBasePackage + ".serializer.protobuf;\n");
        sb.append("import com.google.protobuf.InvalidProtocolBufferException;\n");
        sb.append("import org.yeesoft.ftdc." + struct.getVoClassName() + ";\n");
        sb.append("import org.yeesoft.ftdc.serializer.protobuf.protos." + struct.getProtoClassName() + ";\n");
        sb.append("//" + struct.getComment() + " 转换器 \n");
        sb.append("public class " + struct.getSerializerClassName() + " {\n");

        sb.append("\t//由byte[]转为vo类\n");
        sb.append("\tpublic static " + struct.getVoClassName() +
            " byte2" + struct.getVoClassName() + "(byte[] bytes) {\n");
        sb.append("\t\t" + struct.getProtoClassName() + "." + struct.getMessageName() + " message = null;\n" );
        sb.append("\t\ttry {\n" +
                "\t\t\tmessage = " + struct.getProtoClassName() + "." + struct.getMessageName() +
                ".parseFrom(bytes);\n" +
                "\t\t} catch (InvalidProtocolBufferException e) {\n" +
                "\t\t\te.printStackTrace();\n" +
                "\t\t\treturn null;\n" +
                "\t\t}\n");
        sb.append("\t\treturn message2" + struct.getVoClassName() + "(message);\n}\n");


        sb.append("\t//由Google Protocol Buffer生成的消息对象转换为值对象\n");
        sb.append("\tpublic static " + struct.getVoClassName() + " message2" + struct.getVoClassName() + "("
            + struct.getProtoClassName() + "." + struct.getMessageName() + " message) {\n");
        sb.append("\t\t" + struct.getVoClassName() + " " +
                struct.getVoVarName() + " = new " + struct.getVoClassName() + "();\n");


        String voVarName = struct.getVoVarName();
        for (Field field : struct.getFields()) {
            String ctype = field.getType().getCtype().trim();
            String name = field.getName().trim();
            sb.append("\t\t" + voVarName + ".set" + field.getUpperFirstName() + "(message.get" +
                field.getUpperFirstName() + "()); //" + field.getComment() + "\n");
        }

        sb.append("\t\treturn " + voVarName + ";\n}\n");

        sb.append("//由值对象生成Google Protocol Buffer 消息对象\n");
        sb.append("public static byte[] " + voVarName + "2Message(" + struct.getVoClassName() + " s) {\n");
        sb.append("\t" + struct.getProtoClassName() + "." + struct.getMessageName() + ".Builder t\n");
        sb.append("\t\t=" + struct.getProtoClassName() + "." + struct.getMessageName() + ".newBuilder();\n");
        for (Field field : struct.getFields()) {
            if (field.getType().getCtype().equals("char")) {
            sb.append("\tif (s.get" + field.getUpperFirstName() +"() != null)\n" );
            sb.append("\t\tt.set" + field.getUpperFirstName() + "(s.get" + field.getUpperFirstName() + "()); //"
                + field.getComment() + "\n");
            } else {
                sb.append("\tt.set" + field.getUpperFirstName() + "(s.get" + field.getUpperFirstName() + "()); //"
                        + field.getComment() + "\n");
            }
        }
        sb.append("\t\treturn t.build().toByteArray();\n}\n}\n");
        bw.write(sb.toString());
        bw.close();
    }

    private static BufferedWriter getBW(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(filePath);
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        return new BufferedWriter(osw);
    }

    private static BufferedWriter getBWWithBom(String filePath) throws Exception {
        return Utils.getBW(filePath);
    }

    private static BufferedReader getBR(String filePath) throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
    }

    private static String firstLower(String s) {
       return s.substring(0,1).toLowerCase() + s.substring(1);
    }

    private static String firstUpper(String s) {
        return s.substring(0,1).toUpperCase() + s.substring(1);
    }

    static class Struct {
        private String fullStructName; //形如： struct CThostFtdcForceUserLogoutField
        private String structName; //形如： CThostFtdcForceUserLogoutField
        private String baseName; //形如： ForceUserLogout
        private String cppFileBaseName; //形如： ThostFtdcForceUserLogoutField
        private String voClassName; //形如： ForceUserLogout
        private String voVarName; //形如：  forceUserLogout
        private String messageName; //形如： ForceUserLogoutMessage
        private String protoFileName; //形如： CThostFtdcForceUserLogoutField.proto
        private String protoClassName; //形如： ForceUserLogoutProto
        private String serializerClassName; //形如： ForceUserLogoutConverter
        private String comment;

        List<Field> getFields() {
            return fields;
        }

        void setFields(List<Field> fields) {
            this.fields = fields;
        }

        private List<Field> fields;

        String getBaseName() {
            return baseName;
        }

        String getVoClassName() {
            return voClassName;
        }

        String getVoVarName() {
            return voVarName;
        }

        String getMessageName() {
            return messageName;
        }

        String getProtoClassName() {
            return protoClassName;
        }

        String getSerializerClassName() {
            return serializerClassName;
        }

        String getFullStructName() {
            return fullStructName;
        }

        void setFullStructName(String fullStructName) {
            this.fullStructName = fullStructName;
            structName = fullStructName.replace("struct", "").trim();
            baseName = structName.replace("CThostFtdc", "")
                    .replace("Field", "").trim();
            cppFileBaseName = structName.substring(1);
            voClassName = baseName;
            voVarName = firstLower(voClassName);
            protoFileName = cppFileBaseName + ".proto";
            protoClassName = baseName + "Proto";
            messageName = baseName + "Message";
            serializerClassName = baseName + "Serializer";
        }

        String getComment() {
            return comment;
        }

        void setComment(String comment) {
            this.comment = Utils.trimAll(comment);
        }

        String getProtoFileName() {
            return protoFileName;
        }

        String getStructName() {
            return structName;
        }

        String getCppFileBaseName() {
            return cppFileBaseName;
        }
    }

    static class Field {
        Type getType() {
            return type;
        }

        void setType(Type type) {
            this.type = type;
        }

        private Type type;
        private String name;
        private String comment;
        private String lowercaseFirstName;
        private String upperFirstName;

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
            this.lowercaseFirstName = firstLower(name);
            this.upperFirstName = firstUpper(name);
        }

        String getComment() {
            return comment;
        }

        void setComment(String comment) {
            this.comment = Utils.trimAll(comment);
        }

        String getLowercaseFirstName() {
            return lowercaseFirstName;
        }

        String getUpperFirstName() {
            return upperFirstName;
        }
    }

    static class Type {
        private String name;
        private String ctype;
        private int length;

        String getName() {
            return name;
        }

        void setName(String name) {
            this.name = name;
        }

        String getCtype() {
            return ctype;
        }

        void setCtype(String ctype) {
            this.ctype = ctype;
        }

        int getLength() {
            return length;
        }

        void setLength(int length) {
            this.length = length;
        }
    }
}
