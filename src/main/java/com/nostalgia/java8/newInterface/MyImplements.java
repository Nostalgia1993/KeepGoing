package com.nostalgia.java8.newInterface;

public class MyImplements implements MyInterface{

    @Override
    public void printSomething(String string) {
        System.out.println("我是接口的实现方法...");
    }

    @Override
    public void defaultImplements(String msg) {
        System.out.println(msg.toUpperCase());
    }

    public static void main(String[] args) {
        MyInterface myInterface1 = new MyImplements();
        MyInterface myInterface2 = new MyInterface(){
            @Override
            public void printSomething(String msg){
                System.out.println("匿名内部类实现...带上参数"+msg);
            }

        };
        MyInterface myInterface3 = msg -> System.out.println("lambda实现...带上参数"+msg.substring(msg.indexOf("c")));
        myInterface1.printSomething("abcdefg");
        myInterface2.printSomething("abcdefg");
        myInterface3.printSomething("abcdefg");

    }
}
