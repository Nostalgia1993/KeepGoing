package com.nostalgia.rsa;

import com.alibaba.fastjson.JSON;
import com.nostalgia.http.HttpUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author liunian
 * @createTime 2019/9/11
 * @description 贷款超市产品接入联调
 */
public class TestSentRequestAndVerifyResponse {

    //对方公钥
    private static final String PARTNER_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDS4Z5XqcOzi6bw/6bU7IQYf6kEVIyVBmux+HAlUYQpm+PJhO3FiNsv7a3jEL4hqZs9tQczOZe9LRLQzPGyL/0+/T/9zTW652Bd106uScYXG4DvrPzMexg7kNWhsqWIQGtfTJ/Z2qhHQgSHTG4AS5wsLeeEQQBrbV5oEiFOQhHSSQIDAQAB";
    //我方公钥
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9RtS3TxIykdhAp8Fk+e7Y6Jlty768NDmtt6jIGSnyYpIgG8ZTgeErdlIV8tK4kBMqByRN6J5elRAHydBl6wdIjMM7ycFpUZcYs0NpOJmpyMcC2Dlnj64tMLEwKDXqn9qY31ZSxKh4NcgV5liizVWQj2+cOlO2HT/Gc90pLINLbQIDAQAB";
    //我方私钥
    private static final String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAL1G1LdPEjKR2ECnwWT57tjomW3Lvrw0Oa23qMgZKfJikiAbxlOB4St2UhXy0riQEyoHJE3onl6VEAfJ0GXrB0iMwzvJwWlRlxizQ2k4manIxwLYOWePri0wsTAoNeqf2pjfVlLEqHg1yBXmWKLNVZCPb5w6U7YdP8Zz3Sksg0ttAgMBAAECgYAdT6u/W3Jg/G71zETJw162noasFyJJePj5qvhrTGJPk+43JLX41qMtHNynY3w4cq9VEdgQbJah5QmfeyRXtCbjU5SQk+9c0g5wsuLX93KSpmVzgHkc08O0B15CtKmwp8ztvM9OWHTehkzChkWuWS7z+R5DWzmcDk+KNIAIBsfQLQJBAPos9EezhTggBhNvVmN4wFufVYdKedRC/KMNM5GZ6f0Bsr8dW/ugEX/36w/A9XugFl53FQBfetPvo5l2fSxoBzcCQQDBrutZ//K+gA8Ixb/9MjaQCZZQSYa4QJddevhnLZAmMzAW9tKE2LPqxta9dstW30uGWUA7uHftYZQIbd9peMx7AkBMT+An6vvNFf+keAbbCt9qU10MisxE0jYsKn+7fz6f3Z+/ql3/kGEmLuK2CH8ZOcj5AcwXNAjMk0HNMxaVsBnbAkAWv0Vy54WJ7B5X6Gm5Afm4hve5bDk/UI62cufTrl08r0xZlhl5cr4Gt92mmNoe1NDY8YiCuxKStaAeMVFI4OAbAkBrUDiu/DSId8KVpp+N8iL2ulnZJMyqLmvqsQT6xJgRw8gmA8NmHSJNmnbBecX8UWAgUdtwiHzk6oz/Fb+fl1Pr";
    //合作方渠道
    private static final String CHANNELID = "660i7yppqh";
    //待MD5的字符串
    private static final String MD5 = "13820000000321181199106063128";

    private static final String MOBILE_NO = "13658956745";
    //合作方撞库地址
    private static final String REQUEST_URL = "http://paydayloan.lilei.dsqtest.kuainiujinke.com/external/new360/attack-library";

    private static final String REGISTER_URL = "http://paydayloan.panyu.dsqtest.kuainiujinke.com/asset/third/own360";

    /**
     * 测试自营贷超撞库请求数据并获取返回数据
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        //获取MD5字符串
        String md5String = MD5Util.getMD5String(MD5);
        //组装请求未加密参数
        Map<String,String> readyRequestMap = new HashMap();
        readyRequestMap.put("requestId",UUID.randomUUID().toString().replace("-","").toLowerCase());
        readyRequestMap.put("md5",md5String);
        String readyRequestData = JSON.toJSONString(readyRequestMap);
        System.out.println("未加密的数据:"+readyRequestData);
        //准备加密和签名数据
        Map<String,String> requestMap = new HashMap();
        requestMap.put("channelId", CHANNELID);
        //加密数据
        String requestData = LoanMarketEncryptUtil.rsaEncrypt(readyRequestData,PARTNER_PUBLIC_KEY);
        requestMap.put("requestData",requestData);
        //签名数据
        String sign = LoanMarketSignUtil.rsaSign(PRIVATE_KEY,requestData);
        requestMap.put("sign",sign);
        System.out.println("请求数据:"+JSON.toJSONString(requestMap));

        String response = HttpUtils.http(REQUEST_URL, requestMap);
        System.out.println("返回数据:"+response);
        Map responseMap = JSON.parseObject(response);
        System.out.println();
        //验签
        boolean b = LoanMarketSignUtil.rsaVerifySign(PARTNER_PUBLIC_KEY, responseMap.get("responseData").toString(), responseMap.get("sign").toString());
        System.out.println("是否验签成功:"+b);
        //解密
        String s = LoanMarketEncryptUtil.rsaDecrypt(responseMap.get("responseData").toString(), PRIVATE_KEY);
        //解密
        System.out.println("解密结果:"+s);
    }


    /**
     * 测试自营贷超撞库请求数据并获取返回数据
     * @param args
     * @throws Exception
     */
    public void testPartnerHit() throws Exception{
        //获取MD5字符串
        String md5String = MD5Util.getMD5String(MD5);
        //组装请求未加密参数
        Map<String,String> readyRequestMap = new HashMap();
        readyRequestMap.put("requestId",UUID.randomUUID().toString().replace("-","").toLowerCase());
        readyRequestMap.put("md5",md5String);
        String readyRequestData = JSON.toJSONString(readyRequestMap);
        System.out.println("未加密的数据:"+readyRequestData);
        //准备加密和签名数据
        Map<String,String> requestMap = new HashMap();
        requestMap.put("channelId", CHANNELID);
        //加密数据
        String requestData = LoanMarketEncryptUtil.rsaEncrypt(readyRequestData,PARTNER_PUBLIC_KEY);
        requestMap.put("requestData",requestData);
        //签名数据
        String sign = LoanMarketSignUtil.rsaSign(PRIVATE_KEY,requestData);
        requestMap.put("sign",sign);
        System.out.println("请求数据:"+JSON.toJSONString(requestMap));

        String response = HttpUtils.http(REQUEST_URL, requestMap);
        System.out.println("返回数据:"+response);
        Map responseMap = JSON.parseObject(response);
        System.out.println();
        //验签
        boolean b = LoanMarketSignUtil.rsaVerifySign(PARTNER_PUBLIC_KEY, responseMap.get("responseData").toString(), responseMap.get("sign").toString());
        System.out.println("是否验签成功:"+b);
        //解密
        String s = LoanMarketEncryptUtil.rsaDecrypt(responseMap.get("responseData").toString(), PRIVATE_KEY);
        //解密
        System.out.println("解密结果:"+s);
    }

    /**
     * 测试注册请求数据并获取返回数据
     * @param args
     * @throws Exception
     */
    @Test
    public void regist() throws Exception{
        //组装请求未加密参数
        Map<String,String> readyRequestMap = new HashMap();
        readyRequestMap.put("requestId",UUID.randomUUID().toString().replace("-","").toLowerCase());
        readyRequestMap.put("mobileNo",MOBILE_NO);
        String readyRequestData = JSON.toJSONString(readyRequestMap);
        System.out.println("未加密的数据:"+readyRequestData);
        //准备加密和签名数据
        Map<String,String> requestMap = new HashMap();
        requestMap.put("channelId",CHANNELID);
        //加密数据
        String requestData = LoanMarketEncryptUtil.rsaEncrypt(readyRequestData,PARTNER_PUBLIC_KEY);
        requestMap.put("requestData",requestData);
        //签名数据
        String sign = LoanMarketSignUtil.rsaSign(PRIVATE_KEY,requestData);
        requestMap.put("sign",sign);
        System.out.println("请求数据:"+requestMap.toString());
        String response = HttpUtils.http(REGISTER_URL, requestMap);
        System.out.println("返回数据:"+response);
        Map responseMap = JSON.parseObject(response);
        System.out.println();
        //验签
        boolean b = LoanMarketSignUtil.rsaVerifySign(PARTNER_PUBLIC_KEY, responseMap.get("responseData").toString(), responseMap.get("sign").toString());
        System.out.println("是否验签成功:"+b);
        //解密
        String s = LoanMarketEncryptUtil.rsaDecrypt(responseMap.get("responseData").toString(), PRIVATE_KEY);
        //解密
        System.out.println("解密结果:"+s);

    }



    /*@Test
    public void run(){
        Map<String,String> requestMap = new HashMap<>();
        requestMap.put("service","pps.login.authentication");
        requestMap.put("merchantName","weilaijishi");
        requestMap.put("merchantPwd","62oioO1AhI23");
        requestMap.put("requestSeq","jijiojiojiojhuhuijioj");
        requestMap.put("dataContent","BFiS/QuUz34BJIDQ0nVrrJZpH8K5y8BgG6qQmIyzrKHBjeTPe0dn34cd06ysc2vbesgyrJ+h6mtrFTQUcL0/Yi0i1EfwigpmDnZ4cGp9v4V2rxNbHtU+seUadfzXYX0H3Qn1XOeRGxJVR7VVdVaob9PKCbjitYOzZ+8BALFi/1E=");
        requestMap.put("signature","tMDrbdV/ELA2wANeRGLn7mXwmPfJwvqN+DVJeiv9jpNdpxW+J4zQbOegCk0i0QsxKh4SIno8dkmZzFulom+RqzURJrPtMJLB1ij4hU2pgjJLF7rih+PWjpohETzDPc8ymmnnrCMliYBrLkU+vRy1+FTduQgCYCDt4mdt6G2Mvyk=");
        String http = HttpUtils.http("http://stg1-sfs-web.daikuan.360.cn/sfs/dataservice/v2", requestMap);
        System.out.println(http);
    }*/

    @Test
    public void run(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().replace("-","").toLowerCase());
    }



}
