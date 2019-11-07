package com.nostalgia.string;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testJoin(){
        List<String> list = Arrays.asList("111", "222");
        String join = String.join("|", list);
        System.out.println(join);


    }

}
