package com.nostalgia.clazz;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author liunian
 * @createTime 2019/8/7
 * @description
 */
public class TestClass extends SuperClass<String,Integer>{


    @Test
    public void run(){
        Type genericSuperclass = getClass().getGenericSuperclass();
        System.out.println(genericSuperclass);
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        for (Type type: actualTypeArguments) {
            System.out.println(type);
        }

    }

    public void print(){
        System.out.println("打印...");
    }

    @Test
    public void run1() throws Exception{

        Connection connection = DriverManager.getConnection("");
    }

}
