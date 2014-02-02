/* Copyright */
package org.yeesoft.plutus.toolkit.dev;

import org.yeesoft.plutus.toolkit.dev.sources.DepthMarketData;
import org.yeesoft.plutus.toolkit.dev.sources.Order;
import org.yeesoft.plutus.toolkit.dev.sources.Strategy;
import org.yeesoft.plutus.toolkit.dev.sources.Trade;

import java.io.BufferedWriter;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by yee on 14-1-29.
 */
public class ExchangeGenerator<T> {
    private final static String codeDir =
            "src/main/java/org/yeesoft/plutus/toolkit/dev/sources/";

    private static String targetCodeDir;

    public static void main(String[] args) throws Exception {
        String baseDir = args[0];
        if (baseDir == null) {
            System.out.println("ExchangeGenerator codeBaseDir");
            System.exit(1);
        }

        targetCodeDir = baseDir + "/" + codeDir;

        ExchangeGenerator<Order> orderGenerator =
                new ExchangeGenerator<Order>();
        orderGenerator.generate(Order.class);

        ExchangeGenerator<DepthMarketData> marketDataExchangeGenerator =
                new ExchangeGenerator<DepthMarketData>();
        marketDataExchangeGenerator.generate(DepthMarketData.class);

        ExchangeGenerator<Trade> tradeExchangeGenerator =
                new ExchangeGenerator<Trade>();
        tradeExchangeGenerator.generate(Trade.class);

        ExchangeGenerator<Strategy> strategyExchangeGenerator =
                new ExchangeGenerator<Strategy>();
        strategyExchangeGenerator.generate(Strategy.class);
    }

    private void generate(Class<T> clazz) throws Exception {
        String targetClassName = clazz.getSimpleName() + "Exchange";
        String javaFile = targetCodeDir + "/" + targetClassName + ".java";
        BufferedWriter bw = Utils.getBW(javaFile);
        StringBuffer main = new StringBuffer();
        StringBuffer getterAndSetter = new StringBuffer();
        StringBuffer variable = new StringBuffer();
        main.append("package org.yeesoft.plutus.toolkit.dev.sources;\n\n");

        //main.append("import org.yeesoft.plutus.toolkit.dev.sources.*;\n");
        main.append("public class " + targetClassName + " {\n");

        //根据原始类的字段来生成getter/setter
        for (Field field : clazz.getDeclaredFields()) {
            String baseType = null;
            if (field.getType() == String.class) {
                baseType = "String";
            } else if (field.getType() == Double.class ||
                    field.getType().getSimpleName().equals("double")) {
                baseType = "double";
            } else if (field.getType() == Integer.class ||
                    field.getType().getSimpleName().equals("int")) {
                baseType = "int";
            } else {
                baseType = "Unknown";
            }

            variable.append("\tprivate " + baseType + " " + field.getName() + ";\n");
            getterAndSetter.append(getter(baseType, field.getName()));
            getterAndSetter.append(setter(baseType, field.getName()));
        }

        main.append(variable);
        main.append(getterAndSetter);

        //构造函数
        main.append(construct(clazz.getSimpleName(), targetClassName, clazz.getDeclaredFields()));

        main.append("}\n");

        bw.write(main.toString());
        bw.close();
    }



    private String construct(String baseClassName, String exchangeClassName, Field[] fields) {
        StringBuffer sb = new StringBuffer();
        String baseVarName = Utils.firstLower(baseClassName);
        String exchangeVarName = Utils.firstLower(exchangeClassName);
        sb.append("\n\tpublic static " + exchangeClassName + " from(" + baseClassName + " " +
                baseVarName + ") {\n");
        sb.append("\t\t" + exchangeClassName + " " + exchangeVarName +
                " = new " + exchangeClassName + "();\n");
        for (Field field : fields) {
            sb.append("\t\t" + exchangeVarName + ".set" + Utils.firstUpper(field.getName())
                    + "("  + baseVarName + ".get"
                    + Utils.firstUpper(field.getName()) + "());\n");
        }

        sb.append("\t\treturn " + exchangeVarName + ";\n");
        sb.append("\t}\n");

        return sb.toString();
    }

    private String setter(String type, String name) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\tpublic void set" + Utils.firstUpper(name) + "(" + type + " " + name + ") {\n");
        sb.append("\t\tthis." + name + " = " + name + ";\n");
        sb.append("\t}\n");

        return sb.toString();
    }

    private String getter(String type, String name) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\tpublic " + type +" get" + Utils.firstUpper(name) + "() {\n");
        sb.append("\t\treturn this." + name + ";\n");
        sb.append("\t}\n");

        return sb.toString();
    }
}
