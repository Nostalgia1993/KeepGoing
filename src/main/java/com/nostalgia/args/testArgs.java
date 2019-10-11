package com.nostalgia.args;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liunian
 * @createTime 2019/9/26
 * @description 可变参数如果传空得话,会new一个空的数组
 */
public class testArgs {

    @Test
    public void run(){
        getArgs();
        getArgs("aaa");
        getArgs("aaa","bbb");



    }


    private void getArgs(String... strs){
        System.out.println(strs);
        if(strs != null){
            for (String str : strs){
                System.out.println(str);
            }
            System.out.println("not null...and length of array is :"+strs.length);
        }else{
            System.out.println("null...");
        }

    }

    @Test
    public void run1(){
        int[] ints = {};
        for (int i : ints){
            System.out.println(i);
        }

        List<String> lists = new ArrayList<>();
        for (int i=0 ;i <lists.size();i++){
            System.out.println(lists.get(i));
        }

    }


}
