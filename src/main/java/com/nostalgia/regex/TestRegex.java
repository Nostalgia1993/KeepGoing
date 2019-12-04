package com.nostalgia.regex;

import org.junit.Test;

/**
 * @author liunian
 * @createTime 2019/11/27
 * @description
 */
public class TestRegex {

    @Test
    public void run(){

        String str = "1|2|3|4|5";
        String[] split = str.split("\\|");
        for (String s : split){
            System.out.println(s);
        }

    }

}
