package com.nostalgia.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.scripts.JS;
import org.junit.Test;

import java.util.Map;

/**
 * @author liunian
 * @createTime 2019/8/7
 * @description
 */
public class TestMapInMapToObj {

    @Test
    public  void run(){
        String json = "{\"id\":\"111\",\"name\":\"zhangsan\",\"map\":{\"id\":\"222\",\"name\":\"lisi\"},\"mapObj\":{\"id\":\"333\",\"name\":\"wuwan\"}}";
        MapInMapObj obj = JSON.parseObject(json, MapInMapObj.class);
        /*Map<String,Object> map = JSON.parseObject(json, Map.class);*/
        /*System.out.println(map);
        System.out.println(((Map)map.get("map")).get("id"));
        System.out.println(((Map)map.get("mapObj")).get("name"));*/
        /*System.out.println(obj.getMap().toString());
        System.out.println(obj.getMap().get("name"));
        System.out.println(obj.getMapObj().getId());
        System.out.println(obj.getMapObj().getName());*/

        Map mapObj = (Map) JSON.toJSON(obj);
        System.out.println(mapObj);


    }


    @Test
    public void run1(){
        String json = "{\"id\":\"111\",\"name\":\"zhangsan\",\"map\":{\"id\":\"222\",\"name\":\"lisi\"},\"mapObj\":{\"id\":\"333\",\"name\":\"wuwan\"}}";
        JSONObject obj = JSONObject.parseObject(json);
        MapInMapObj mapInMapObj = JSONObject.toJavaObject(obj, MapInMapObj.class);
        System.out.println(mapInMapObj);
    }

}
