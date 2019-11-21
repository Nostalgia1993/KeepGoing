package com.nostalgia.AES;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.nostalgia.rsa.MD5Util;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author liunian
 * @createTime 2019/9/3
 * @description
 */
public class TestAES {


    /*private static String aesKey = "fheijERH235GS63A";*/
    private static String aesKey = "8gP6jw292sDgmEJv";
    /*private static String aesKey = "j4mcn6bv8wt2yeui";*/

    /**
     * 解密
     * @throws Exception
     */
    @Test
    public void run() throws Exception{
        /*String requestData ="YUo1uSRVdAiQMOC8ZQUMnWgJZ0rufHrKjXglLAxCj9XQmPJtyBBV3alxHQZBOuNsYQz83SMOu1/L\\nTtRC1GAragodpUUNF7Hv+2jqyTZ+bZJZc6fhYqkLzktnTn3mZH3mm/TCUidQ2ZypVtz5ywDrOACH\\njyqcp0l7TqBDxNKykoCAsjJr1Jo0+637aGLnbS7qtctPJGtn3KM7g25ve245cQ==";*/
        String requestData ="YUo1uSRVdAiQMOC8ZQUMnWgJZ0rufHrKjXglLAxCj9XQmPJtyBBV3alxHQZBOuNsYQz83SMOu1/L" +
                "TtRC1GAragodpUUNF7Hv+2jqyTZ+bZJZc6fhYqkLzktnTn3mZH3mm/TCUidQ2ZypVtz5ywDrOACH" +
                "jyqcp0l7TqBDxNKykoCTwY1k9g7lg+BiOOQ9FMmYtctPJGtn3KM7g25ve245cQ==";
        String origReqStr = AESUtil.aesDecrypt(requestData, AESUtil.base64Encode(aesKey));
        System.out.println(origReqStr);
    }


    /**
     * 解密
     * @throws Exception
     */
    @Test
    public void run22() throws Exception{
        String requestData ="PfUUkR0qsNoJXqhoPVA5D5DZ0UAtTE8Us%2Fd73vZHzukQAV%2F3e%2FQau7r94bfNVZdv2Hsjn%2FUeu%2FJq%0AvXcqORG4Q%2F2JNVec74dRa8v%2FMiLoFZQ%3D";
        String origReqStr = AESUtil.aesDecrypt(requestData, AESUtil.base64Encode(aesKey));
        System.out.println(origReqStr);
    }



    /**
     * 加密
     * @throws Exception
     */
    @Test
    public void run1() throws Exception{
        String string = "YUo1uSRVdAiQMOC8ZQUMnWgJZ0rufHrKjXglLAxCj9XQmPJtyBBV3alxHQZBOuNsYQz83SMOu1/L\n" +
                "TtRC1GAragodpUUNF7Hv+2jqyTZ+bZJZc6fhYqkLzktnTn3mZH3mJQo3m3WaZosM3rgOt+JVGw/1\n" +
                "TTc6y8VgV6Xf2SPJ4G1th8AaMxSPYUBBSOdatiaaM+wqyB8GTZO4jgOwdz86Fg==";
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("mobile","15865432596");
        hashMap.put("timestamp",1574068693395L);
        hashMap.put("redirect","https://cdn-daikuan.360jie.com.cn/dir_mkteditor/activity/qmmx/mobile/1.3.0/12m1jtsuccess.html");
        String jsonString = JSON.toJSONString(hashMap);
        System.out.println(jsonString);
        String partnerKey = "8gP6jw292sDgmEJv";
        String s = AESUtil.aesEncrypt(jsonString, AESUtil.base64Encode(partnerKey));
        System.out.println("加密后的数据:"+s);
        System.out.println("string:"+string);
        System.out.println("是否相等:"+s.equals(string));

        //解密
        String result = AESUtil.aesDecrypt(s, AESUtil.base64Encode(partnerKey));
        System.out.println(result);

    }

    @Test
    public void run2() throws Exception{
        String josn = "{\"result\": 1}";
        //加密
        String key = "1234567890123456";
        String data = AESUtil.aesEncrypt(josn, AESUtil.base64Encode(key));
        System.out.println(data);
        /*String data2 = AESUtil.aesEncrypt(josn, AESUtil.base64Encode(key));
        System.out.println(data);
        System.out.println(data2);
        System.out.println(data.equals(data2));;
        //解密
        String origReqStr = AESUtil.aesDecrypt(data, AESUtil.base64Encode(key));
        System.out.println(origReqStr);*/
    }


    @Test
    public void run4() throws Exception{
        String json = "{\"mobile\":\"13530227501\",\"timestamp\":1574068693395}";
        String key = "8gP6jw292sDgmEJv";
        String data = AESUtil.aesEncrypt(json, AESUtil.base64Encode(key));
        System.out.println(data);
        //解密
        String str = AESUtil.aesDecrypt(data, AESUtil.base64Encode(key));
        System.out.println(str);
    }

    @Test
    public void run33(){

        System.out.println(MD5Util.getMD5String("13530227501"));
    }

}
