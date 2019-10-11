package com.nostalgia.json.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;

import java.util.Map;

/**
 * @author liunian
 * @createTime 2019/8/12
 * @description
 *
 * 对象转String
 *     JSON.toJSONString(Object)
 * 对象转JSONObject
 *     (JSONObject)JSON.toJson(Object) //需要强转
 * 对象转Map
 *     1:(Map)JSON.toJson()  //转为对象,然后强转为Map
 *     2:JSON.parseObject(JSON.toJSONString(javaBean)) //先转为String,再转为JsonObject,直接返回Map
 *
 */
public class JsonToString {


    /**
     * 对象转String
     * 直接调用JSON.toJSONString(Object)即可
     */
    @Test
    public void objectToJson(){
        InnerBean innerBean = new InnerBean("1111","2222");
        JavaBean javaBean = new JavaBean("3333","4444",5555,innerBean);
        String string = JSON.toJSONString(javaBean);
        System.out.println(string);
    }

    /**
     * Object转JSONObject
     * 调用Object = JSON.toJson(Object),然后强转为JSONObject
     *
     */
    @Test
    public void objectToJsonObject() {
        JavaBean javaBean = new JavaBean("3333","4444",5555,new InnerBean("1111","2222"));
        JSONObject object = (JSONObject)JSON.toJSON(javaBean);
        System.out.println(object);
    }

    /**
     *  Object转Map
     *  1:toJson()转为对象,然后强转为Map
     *  2:先转为String,再转为JsonObject,直接返回Map
     */
    @Test
    public void objectToMap() {
        JavaBean javaBean = new JavaBean("3333","4444",5555,new InnerBean("1111","2222"));
        //方法1:直接toJson()转为对象,然后强转为Map
        Map<String,Object> map =(Map<String,Object>) JSON.toJSON(javaBean);
        //方法2:先转为String,再转为JsonObject,直接返回Map
        Map<String,Object> map2 = JSON.parseObject(JSON.toJSONString(javaBean));
        new JSONObject();
    }

    /**
     * 对象的空属性转成空串
     */
    @Test
    public void objectToStrWithEmptyStr() {
        JavaBean javaBean = new JavaBean("3333","4444",5555,new InnerBean("1111",null));
        JavaBean javaBean1 = new JavaBean("3333",null,5555,new InnerBean("1111",null));
        System.out.println(JSON.toJSONString(javaBean,SerializerFeature.WriteMapNullValue));
        System.out.println(JSON.toJSONString(javaBean1,SerializerFeature.WriteMapNullValue));
        System.out.println(JSON.toJSONString(javaBean1,SerializerFeature.WriteNullStringAsEmpty));
        System.out.println(JSON.toJSONString(javaBean1));
    }

    @Test
    public void objetrWithEmptyStr() {
        String aa = null;
        System.out.println(aa+"");

    }

}
