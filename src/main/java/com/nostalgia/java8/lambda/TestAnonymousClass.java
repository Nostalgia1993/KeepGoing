package com.nostalgia.java8.lambda;

import java.util.Comparator;

/**
 * @author liunian
 * @createTime 2019/9/16
 * @description
 */
public class TestAnonymousClass {

    public static void main(String[] args) {
        MathOperate operate =  (a, b) -> a + b;
        System.out.println(operate.operate(3,5));
        //匿名内部类方式
        MathOperate mathOperate = new MathOperate(){
            @Override
            public int operate(int a,int b){
                return a+b;
            }
        };
        System.out.println(mathOperate.operate(4,5));
    }




    interface MathOperate{

        int operate(int a,int b);

    }
}
