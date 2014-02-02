package org.yeesoft.plutus.toolkit.dev;/* Copyright */

import com.sun.org.apache.xerces.internal.xs.StringList;
import org.yeesoft.plutus.toolkit.dev.sources.*;

import java.io.BufferedWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yee on 14-1-28.
 */
public class PropertyWrapperGenerator<T> {
    private final static String codeDir =
            "src/main/java/org/yeesoft/plutus/toolkit/dev/sources/";

    private static String targetCodeDir;

    public static void main(String[] args) throws Exception {
        String baseDir = args[0];
        if (baseDir == null) {
            System.out.println("PropertyWrapperGenerator codeBaseDir");
            System.exit(1);
        }

        targetCodeDir = baseDir + "/" + codeDir;

        PropertyWrapperGenerator<OrderExchange>
                orderGenerator = new PropertyWrapperGenerator<OrderExchange>();
        orderGenerator.generate(OrderExchange.class, new String[]{"frontID", "sessionID", "orderRef"});

        PropertyWrapperGenerator<DepthMarketDataExchange>
                depthMarketDataPropertyWrapperGenerator = new PropertyWrapperGenerator<DepthMarketDataExchange>();
        depthMarketDataPropertyWrapperGenerator.generate(DepthMarketDataExchange.class, new String[]{"instrumentID"});

        PropertyWrapperGenerator<TradeExchange>
                tradePropertyWrapperGenerator = new PropertyWrapperGenerator<TradeExchange>();
        tradePropertyWrapperGenerator.generate(TradeExchange.class, new String[]{"orderSysID"});

        PropertyWrapperGenerator<Strategy>
                strategyExchangePropertyWrapperGenerator = new PropertyWrapperGenerator<Strategy>();
        strategyExchangePropertyWrapperGenerator.generate(Strategy.class, new String[] {"name"});
    }

    private String imp() {
        StringBuffer imp = new StringBuffer();
        imp.append("import javafx.beans.property.SimpleStringProperty;\n");
        imp.append("import javafx.beans.property.SimpleDoubleProperty;\n");
        imp.append("import javafx.beans.property.SimpleIntegerProperty;\n");
        imp.append("import java.util.LinkedHashMap;\n");
        imp.append("import java.util.Map;\n");
        imp.append("import org.apache.commons.lang3.builder.EqualsBuilder;\n");
        imp.append("import org.apache.commons.lang3.builder.CompareToBuilder;\n");
        imp.append("import org.apache.commons.lang3.builder.HashCodeBuilder;\n");

        return imp.toString();
    }

    private String update(String className, String targetClassName, Field[] fields) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\tpublic void update(" + targetClassName + " o) { \n");
        for (Field f : fields) {
            sb.append("\t\tset" + Utils.firstUpper(f.getName()) + "(o.get" +
                    Utils.firstUpper(f.getName()) + "());\n");
        }
        sb.append("\t}\n");

        sb.append("\n\tpublic void update(" + className + " o) { \n");
        for (Field f : fields) {
            sb.append("\t\tset" + Utils.firstUpper(f.getName()) + "(o.get" +
                    Utils.firstUpper(f.getName()) + "());\n");
        }
        sb.append("\t}\n");

        return sb.toString();
    }

    private String hashMapKey(String className, String targetClassName, String[] keyFields) {
        StringBuffer sb = new StringBuffer();
        String varName = Utils.firstLower(className);
        sb.append("\n\tpublic static String hashMapKey(" + className + " " + varName +") {\n");
        sb.append("\t\tStringBuffer sb =  new StringBuffer();\n");
        for (String f : keyFields) {
            sb.append("\t\tsb.append(" + varName + ".get" + Utils.firstUpper(f)  + "());\n");
        }
        sb.append("\t\treturn sb.toString();\n");
        sb.append("\t}\n");

        varName = Utils.firstLower(targetClassName);
        sb.append("\n\tpublic static String hashMapKey(" + targetClassName + " " + varName +") {\n");
        sb.append("\t\tStringBuffer sb =  new StringBuffer();\n");
        for (String f : keyFields) {
            sb.append("\t\tsb.append(" + varName + ".get" + Utils.firstUpper(f)  + "());\n");
        }
        sb.append("\t\treturn sb.toString();\n");
        sb.append("\t}\n");
        return sb.toString();
    }

    private String equals(String className, String[] equalFields) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\t@Override");
        sb.append("\n\tpublic boolean equals(Object obj) {\n");
        sb.append("\t\tif (obj == null) return false;\n");
        sb.append("\t\tif (this == obj) return true;\n");
        sb.append("\t\tif (obj.getClass() == " + className + ".class) {\n");
        sb.append("\t\t\t" + className + " s = (" + className + ")obj;\n");
        sb.append("\t\t\treturn new EqualsBuilder()\n");
        for (String f : equalFields) {
            sb.append("\t\t\t\t\t.append(this.get" + Utils.firstUpper(f) + "(), s.get" +
                    Utils.firstUpper(f) + "())\n");
        }
        sb.append("\t\t\t\t\t.isEquals();\n");
        sb.append("\t\t}\n");
        sb.append("\t\treturn false;\n");
        sb.append("\t}\n");

        return sb.toString();
    }

    private String compareTo(String className, String[] compareFields) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\t@Override");
        sb.append("\n\tpublic int compareTo(" + className + " o) {\n");
        sb.append("\t\treturn new CompareToBuilder()\n");
        for (String f : compareFields) {
            sb.append("\t\t\t\t.append(this.get" + Utils.firstUpper(f) + "(), o.get" +
                    Utils.firstUpper(f) + "())\n");
        }
        sb.append("\t\t\t\t.toComparison();\n");
        sb.append("\t}\n");

        return sb.toString();
   }

    private String hash(String[] hashFields) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\t@Override");
        sb.append("\n\tpublic int hashCode() {\n");
        sb.append("\t\treturn new HashCodeBuilder()\n");
        for (String f : hashFields) {
            sb.append("\t\t\t\t.append(this.get" + Utils.firstUpper(f) + "())\n");
        }
        sb.append("\t\t\t\t.hashCode();\n");
        sb.append("\t}\n");

        return sb.toString();
    }

    private void generate(Class<T> clazz, String[] keyFields) throws Exception {
        StringBuffer main = new StringBuffer();
        StringBuffer getterAndSetter = new StringBuffer();
        StringBuffer variable = new StringBuffer();
        String targetClassName = clazz.getSimpleName() + "Property";
        String javaFile = targetCodeDir + "/" + targetClassName + ".java";
        BufferedWriter bw = Utils.getBW(javaFile);
        main.append("package org.yeesoft.plutus.toolkit.dev.sources;\n\n");
        main.append(imp());

        main.append("public class " + targetClassName + " implements Comparable<" + targetClassName +"> {\n");

        //根据原始类的字段来生成getter/setter
        for (Field field : clazz.getDeclaredFields()) {
            //将类型替换成对应的JavaFx Property类型
            //只支持基本类型,对于非基本类型， 使用该类型的toString转换为SimpleStringProperty
            String propertyType =  null;
            String baseType = null;
            if (field.getType() == String.class) {
                propertyType =  "SimpleStringProperty";
                baseType = "String";
            } else if (field.getType() == Double.class ||
                    field.getType().getSimpleName().equals("double")) {
                propertyType =  "SimpleDoubleProperty";
                baseType = "double";
            } else if (field.getType() == Integer.class ||
                    field.getType().getSimpleName().equals("int")) {
                propertyType =  "SimpleIntegerProperty";
                baseType = "int";
            } else {
                propertyType =  "SimpleStringProperty";
                baseType = "String";
            }

            variable.append("\tprivate final " + propertyType + " " + field.getName() + ";\n");
            getterAndSetter.append(getter(propertyType, baseType, field.getName()));
            getterAndSetter.append(setter(baseType, field.getName()));
        }

        main.append(variable);

        main.append(buildColumns(clazz.getDeclaredFields()));

        main.append(hashMapKey(clazz.getSimpleName(), targetClassName, keyFields));

        //构造函数
        main.append(construct(clazz.getSimpleName(), targetClassName, clazz.getDeclaredFields()));

        main.append(update(clazz.getSimpleName(), targetClassName, clazz.getDeclaredFields()));

        main.append(getterAndSetter);

        main.append(equals(targetClassName, keyFields));

        main.append(compareTo(targetClassName, keyFields));

        main.append(hash(keyFields));

        main.append("}\n");

        bw.write(main.toString());
        bw.close();
    }

    private String buildColumns(Field[] fields) {
        StringBuffer sb = new StringBuffer();

        sb.append("\tpublic static Map<String, String> buildColumnMap() {\n");
        sb.append("\t\tMap<String, String> map = new  LinkedHashMap<String, String>();\n");
        for (Field field : fields) {
            sb.append("\t\tmap.put(\"" + field.getName() + "\", \""
                    + field.getName() + "\");\n");
        }
        sb.append("\t\treturn map;\n");
        sb.append("\t}\n");
        return sb.toString();
    }

    private String construct(String baseClassName, String propertyClassName, Field[] fields) {
        StringBuffer sb = new StringBuffer();
        String baseVarName = Utils.firstLower(baseClassName);
        sb.append("\tpublic " + propertyClassName + "(" + baseClassName + " " +
                 baseVarName + ") {\n");
        String propertyType =  null;
        for (Field field : fields) {
            if (field.getType() == String.class) {
                propertyType =  "SimpleStringProperty";
            } else if (field.getType() == Double.class ||
                    field.getType().getSimpleName().equals("double")) {
                propertyType =  "SimpleDoubleProperty";
            } else if (field.getType() == Integer.class ||
                    field.getType().getSimpleName().equals("int")) {
                propertyType =  "SimpleIntegerProperty";
            } else {
                propertyType =  "SimpleStringProperty";
            }

            sb.append("\t\t" + field.getName() + " = new " + propertyType + "("
                    + baseVarName + ".get" + Utils.firstUpper(field.getName()) + "());\n");
        }

        sb.append("\t}\n");

        return sb.toString();
    }

    private String setter(String baseType, String name) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\tpublic void set" + Utils.firstUpper(name) + "(" + baseType + " " + name + ") {\n");
        sb.append("\t\tthis." + name + ".set(" + name + ");\n");
        sb.append("\t}\n");

        return sb.toString();
    }

    private String getter(String propertyType, String baseType, String name) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\tpublic " + propertyType + " " + name + "Property() {\n");
        sb.append("\t\treturn " + name + ";\n");
        sb.append("\t}\n");

        sb.append("\tpublic " + baseType +" get" + Utils.firstUpper(name) + "() {\n");
        sb.append("\t\treturn " + name + ".get();\n");
        sb.append("\t}\n");

        return sb.toString();
    }
}
