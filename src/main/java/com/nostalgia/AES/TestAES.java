package com.nostalgia.AES;

import org.junit.Test;

/**
 * @author liunian
 * @createTime 2019/9/3
 * @description
 */
public class TestAES {


    private static String aesKey = "k3j6uhg8hu9rh1gu";
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
        String requestData ="QyiOzRiB2jjUV0Id8lTkdu8KNjszNiGEC5qxBiKvaXrGgsoCzyVCND25j9wqKGURjZJCrnJ9kQP%2FVpx9m8cwkBNOsRIl7gQMpT5imexnnG8%3D";
        System.out.println();
    }



    /**
     * 加密
     * @throws Exception
     */
    @Test
    public void run1() throws Exception{
        String json = "{\"hitType\":\"MOBILE\",\"mobileNo\":\"15887654321\",\"ip\":\"121.199.32.111\"}";
        String partnerKey = "qyu3erriev7kmvkx";
        String s = AESUtil.aesEncrypt(json, AESUtil.base64Encode(partnerKey));
        System.out.println(s);
    }

    @Test
    public void run2() throws Exception{
        String josn = "{\"hitType\":\"MOBILE\",\"mobileNo\":\"15887654321\",\"ip\":\"121.199.32.111\"}";
        //加密
        String data = AESUtil.aesEncrypt(josn, AESUtil.base64Encode(aesKey));
        System.out.println(data);
        //解密
        String origReqStr = AESUtil.aesDecrypt(data, AESUtil.base64Encode(aesKey));
        System.out.println(origReqStr);
    }


}
