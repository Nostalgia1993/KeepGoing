package com.nostalgia.enumTest;

/**
 * @author liunian
 * @createTime 2019/10/30
 * @description
 */
public enum MyEnum {

    Case1("name","liunian"),
    Case2("age","111");

    private String name;

    private String value;

    MyEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
