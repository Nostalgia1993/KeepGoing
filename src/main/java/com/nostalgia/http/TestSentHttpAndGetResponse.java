package com.nostalgia.http;

import com.alibaba.fastjson.JSON;
import com.nostalgia.AES.AESUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author liunian
 * @createTime 2019/9/17
 * @description
 */
public class TestSentHttpAndGetResponse {


    private static String aesKey = "fhe2ufh8sijfieso";

    public static void main(String[] args) throws Exception{
        String url ="http://36.110.233.236/openapi/partnerhit/uCheck.do";
        Map<String,String> map = new HashMap();
        map.put("partnerName","qingdai");
        map.put("channelId","H5_CH_17093");
        map.put("requestId",UUID.randomUUID().toString().replace("-","").toLowerCase());
        //组装加密数据
        Map<String,String> requestdata = new HashMap();
        requestdata.put("hitType","MOBILE");
        requestdata.put("mobileNo","15963247856");
        requestdata.put("ip","127.0.0.1");
        String json = JSON.toJSONString(requestdata);
        System.out.println(json);
        String data = AESUtil.aesEncrypt(json, AESUtil.base64Encode(aesKey));
        System.out.println(data);
        map.put("requestData",data);

        String s = HttpUtils.http(url, map);
        System.out.println(s);

    }


}
