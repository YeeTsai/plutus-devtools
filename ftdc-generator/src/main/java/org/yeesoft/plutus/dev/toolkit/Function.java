package org.yeesoft.plutus.dev.toolkit;

import java.util.ArrayList;
import java.util.List;

/**
 * plutus
 * Written by Yee at 13-11-18 下午3:35
 */
public class Function {
    private String name;
    private String fullName;
    private String returnType;
    private List<Argument> callArgs = new ArrayList();
    private List<String> comments = new ArrayList();
    private String signature;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getReturnType() {
        return returnType;
    }

    void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    List<String> getCallArgsString() {
        List<String> argsString = new ArrayList();
        for (Argument arg : callArgs) {
            argsString.add(arg.toString());
        }
        return argsString;
    }

    List<Argument> getCallArgs() {
        return callArgs;
    }

    void addCallArg(Argument argument) {
        callArgs.add(argument);
    }

    List<String> getComments() {
        return comments;
    }

    void addComment(String comment) {
        comments.add(comment);
    }

    String getSignature() {
        return signature;
    }

    void setSignature(String signature) {
        this.signature = signature;
    }

    String getFullName() {
        return fullName;
    }

    void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
