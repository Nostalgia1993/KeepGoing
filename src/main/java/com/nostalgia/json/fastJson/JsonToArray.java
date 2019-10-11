package com.nostalgia.json.fastJson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.List;

/**
 * @author liunian
 * @createTime 2019/8/12
 * @description
 *
 * 数组字符串转数组:
 *     JSON.parseArray(String,Class);
 * 获取在对象中的数组:
 *     JSON.parseObject(String)得到JSONObject对象
 *     JSONObject.getJSONArray(String)得到数组
 *
 */
public class JsonToArray {

    @Test
    public void jsonToArray(){
        String jsonString = "{\"id\":\"111\",\"groups\":[\"group1\",\"group2\"],\"beans\":[{\"id\":\"inner1\",\"sex\":\"innerSex1\"},{\"id\":\"inner2\",\"sex\":\"innerSex2\"}]}";
        ArrayBean arrayBean = JSON.parseObject(jsonString, ArrayBean.class);
        System.out.println(arrayBean);
    }

    @Test
    public void jsonToArray1(){
        String jsonString = "{\"id\":\"111\",\"groups\":[\"group1\",\"group2\"],\"beans\":[{\"id\":\"inner1\",\"sex\":\"innerSex1\"},{\"id\":\"inner2\",\"sex\":\"innerSex2\"}]}";
        JSONObject jsonObject = JSON.parseObject(jsonString);
        List groups = jsonObject.getJSONArray("groups");
        groups.stream().forEach(string-> System.out.println(string));
    }

    /**
     * ArrayString转List
     *     JSON.parseArray(String)
     */
    @Test
    public void jsonToArray2(){
        String jsonString = "[{\"id\":\"inner1\",\"sex\":\"innerSex1\"},{\"id\":\"inner2\",\"sex\":\"innerSex2\"}]";
        List<InnerBean> beans= JSON.parseArray(jsonString,InnerBean.class);
        beans.stream().forEach(bean-> System.out.println(bean));
    }

}
