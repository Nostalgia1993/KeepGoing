package com.nostalgia.java8.newInterface;

public interface MyInterface {

    void printSomething(String string);

    default void defaultImplements(String msg){
        System.out.println("我是接口的默认实现...顺便带上信息:"+msg);
    }
}
