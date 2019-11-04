package com.nostalgia.clazz;

/**
 * @author liunian
 * @createTime 2019/10/18
 * @description
 */
public class TestInnerClass {



    public void method(int num){

        InnerClass inner = new InnerClass(){
            @Override
            public void run(){
                int num1 = num;
            }
        };
    }


    public class InnerClass{
        public void run(){

        }
    }
}
