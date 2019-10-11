package com.nostalgia.json.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;

/**
 * @author liunian
 * @createTime 2019/8/9
 * @description
 *
 * String转JSONObject:
 *     JSONObject = JSON.parseObject(String);
 * String转Map:
 *     JSONObject = JSON.parseObject(String);
 *     JSONObject向上转换为Map即可,转成Map<String,String>需设置强转,而Map<String,Object>不需要设置强转
 * String转Object:
 *     JavaObject = JSON.parseObject(String,Class);
 */
public class StringToJson {

    /**
     * String转JSONObject
     * JSON.parseObject(String)
     * JSONObject是Map接口的实现类
     *
     */
    @Test
    public void stringtoJSONObject(){
        String jsonString = "{\"id\":\"111\",\"name\":\"javaBeanName\",\"num\":222,\"innerBean\":{\"id\":\"333\",\"name\":\"innerBeanName\"}}";
        JSONObject jsonObject = JSON.parseObject(jsonString);
        System.out.println(jsonObject);
        System.out.println(jsonString);
    }

    /**
     * String转Map
     * JSON.parseObject(String)即可
     * 转成Map可以直接转,转成Map<String,Object>/Map<String,String>需要设置强转
     *
     */
    @Test
    public void stringtoMap(){
        //正常JsonString
        String jsonString  = "{\"id\":\"111\",\"name\":\"javaBeanName\",\"num\":222,\"innerBean\":{\"id\":\"333\",\"name\":\"innerBeanName\"}}";
        //里面包含对象字符串的Json
        String jsonString1 = "{\"id\":\"111\",\"name\":\"javaBeanName\",\"num\":222,\"innerBean\":\"{\\\"id\\\":\\\"333\\\",\\\"sex\\\":\\\"innerBeanName\\\"}\"}";
        Map map = JSON.parseObject(jsonString);
        System.out.println(map);
        System.out.println("=================1111================");
        Map<String,Object> stringMap = (Map<String,Object>)JSON.parse(jsonString);
        System.out.println("这里能执行...");
        InnerBean innerBean2 = JSON.toJavaObject(((JSONObject)stringMap.get("innerBean")),InnerBean.class);
        System.out.println("innerBeanString:  "+innerBean2);
        System.out.println(stringMap);
        System.out.println("=================2222================");
        //处理jsonString1
        /*JavaBean javaBean = JSON.parseObject(jsonString1,JavaBean.class);
        System.out.println(javaBean);*/
        System.out.println("=================3333================");
        JSONObject jsonObject = JSON.parseObject(jsonString1);
        String innerBean =(String) jsonObject.get("innerBean");
        System.out.println("innerBean:     "+innerBean);
        InnerBean innerBean1 = JSON.parseObject(innerBean,InnerBean.class);
        System.out.println("innerBeanClass:     "+innerBean1);
    }

    /**
     * 小心Json字段中间有空格
     * InnerBean{id='null', sex='innerBeanName'}
     */
    @Test
    public void run(){
        String str ="{\"id \":\"333\",\"sex\":\"innerBeanName\"}";
        System.out.println(str);
        InnerBean innerBean1 = JSON.parseObject(str,InnerBean.class);
        System.out.println(innerBean1);

    }

    /**
     * String转对象
     * 使用JSON.parseObject(String,Class)方法
     *
     */
    @Test
    public void stringToObject(){
        String jsonString  = "{\"id\":\"111\",\"name\":\"javaBeanName\",\"sum\":222,\"innerBean\":{\"id\":\"333\",\"name\":\"innerBeanName\"}}";
        JavaBean javaBean = JSON.parseObject(jsonString, JavaBean.class);
        System.out.println(javaBean);
    }

    @Test
    public void stringToObject1(){
        String s = "{\"successUrl\" : \"https://mkt.xjietiao.com/activity/ch/ycapi/lanmu\", \"key\" : \"fheijERH235GS63A\", \"channelId\" : \"H5_CH_17010\", \"partnerDesc\" : \"鱼传\"}";
        Map<String, String> partnerConfigMap = (Map<String, String>) JSON.parse(s);
        System.out.println(partnerConfigMap.get("key"));
    }
}
