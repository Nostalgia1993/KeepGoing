package com.nostalgia.clazz;

import com.alibaba.fastjson.JSONObject;
import com.nostalgia.json.MapInMapObj;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.Map;

/**
 * @author liunian
 * @createTime 2019/8/7
 * @description
 */
public class TestBeanUtils {

    @Test
    public void run() throws Exception{

        String json = "{\"id\":\"111\",\"name\":\"zhangsan\",\"map\":{\"id\":\"222\",\"name\":\"lisi\"},\"mapObj\":{\"id\":\"333\",\"name\":\"wuwan\"}}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        Map<String,Object> map = jsonObject;
        System.out.println(map.toString());
        MapInMapObj mapInMapObj = new MapInMapObj();
        BeanUtils.populate(mapInMapObj,map);
        System.out.println(mapInMapObj.getMap().get("id"));
        System.out.println(mapInMapObj.getMap().get("name"));
        System.out.println(mapInMapObj.getId());
        System.out.println(mapInMapObj.getName());

    }


    public static <T> T getType(String clazz) throws Exception{
        return (T) Class.forName(clazz).newInstance();
    }

    @Test
    public void run2() throws Exception{
        TestClass testClass = getType("com.nostalgia.clazz.TestClass");
        testClass.print();

    }
}
