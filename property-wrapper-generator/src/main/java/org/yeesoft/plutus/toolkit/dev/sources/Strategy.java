/*
 * Copyright (c) 2013. yeesoft.org All Right Reserve.
 */
package org.yeesoft.plutus.toolkit.dev.sources;

import java.io.Serializable;

/**
 * Plutus
 * create at  13-12-20 下午3:42
 * by Yee@yeesoft.org
 */
public class Strategy implements Serializable {
    private String id;
    private String name;
    private String className;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\nID[标识]:");
        sb.append(id);
        sb.append("\nname[名称]:");
        sb.append(name);
        sb.append("\nclassName[类名]:");
        sb.append(className);
        sb.append("\ndescription[描述]:");
        sb.append(description);

        return sb.toString();
    }
}
