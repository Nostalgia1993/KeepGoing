package com.nostalgia.AES;

import org.junit.Test;

/**
 * @author liunian
 * @createTime 2019/9/3
 * @description
 */
public class TestAES {


    /*private static String aesKey = "fheijERH235GS63A";*/
    private static String aesKey = "fhesuhfuesh2f4ui";
    /*private static String aesKey = "j4mcn6bv8wt2yeui";*/

    /**
     * 解密
     * @throws Exception
     */
    @Test
    public void run() throws Exception{
        String requestData ="PXphJdJrEMx37XKgAzpLtJCVsnqNnC8P3JinXApeRRaRbOUWfCwOc/MRXAorfAMge+C5LHkR0+jakUkkd5CA74kFjF1ufqovje/9uwMXpAE=";
        String origReqStr = AESUtil.aesDecrypt(requestData, AESUtil.base64Encode(aesKey));
        System.out.println(origReqStr);
    }


    /**
     * 解密
     * @throws Exception
     */
    @Test
    public void run22() throws Exception{
        String requestData ="Zq/mgaE57jO5n1qYsfegoSnkb4m/3X9M8KdhlUNx3EmYqTekF4bfDEtQLZ7JubgU";
        String origReqStr = AESUtil.aesDecrypt(requestData, AESUtil.base64Encode(aesKey));
        System.out.println(origReqStr);
    }



    /**
     * 加密
     * @throws Exception
     */
    @Test
    public void run1() throws Exception{
        String json = "{\"hitType\":\"MOBILE\",\"mobileNo\":\"15841526354\",\"ip\":\"121.199.32.111\"}";
        String partnerKey = "fheijERH235GS63A";
        String s = AESUtil.aesEncrypt(json, AESUtil.base64Encode(partnerKey));
        System.out.println(s);
    }

    @Test
    public void run2() throws Exception{
        String josn = "{\"flowNo\":\"P5907944140313735168\",\"mobileNo\":\"15996325874\"}";
        //加密
        String key = "Vxjeadc6xSTVx8HN";
        String data = AESUtil.aesEncrypt(josn, AESUtil.base64Encode(key));
        String data2 = AESUtil.aesEncrypt(josn, AESUtil.base64Encode(key));
        System.out.println(data);
        System.out.println(data2);
        System.out.println(data.equals(data2));;
        //解密
        String origReqStr = AESUtil.aesDecrypt(data, AESUtil.base64Encode(key));
        System.out.println(origReqStr);
    }


}
