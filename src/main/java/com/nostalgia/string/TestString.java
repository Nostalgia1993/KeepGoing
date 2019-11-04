package com.nostalgia.string;

import org.junit.Test;

/**
 * @author liunian
 * @createTime 2019/8/19
 * @description
 */
public class TestString {

    @Test
    public void run(){
        StringBuilder sb = new StringBuilder();
        String aa = null;
        sb.append(aa).append("sssss");
        System.out.println(sb.toString());


    }


    @Test
    public void run1(){

        try {
            System.out.println("我要执行了...");
            int i = 1/0;
            System.out.println("我在后面执行了...");
        } catch (Exception e) {
            System.out.println("只有我能执行");
        }

    }

}
