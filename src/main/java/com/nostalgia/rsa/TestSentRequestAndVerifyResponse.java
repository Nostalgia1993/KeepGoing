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
    private static final String PARTNER_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQ9twqyPiTn1KH/c+xLCSCa3JQS6WmXp1B0gp3nzvg+NIdDsggoN+ScO0jH1640LqJHpX563oe74rT4wZHHLxunOonwO4m0wmIC8VyjdqHALSb9rKkvS693uIVcUn8pcwO66rMec9/QFdrWjrlnfqqyofjoG7HllPa7NjONPB7QwIDAQAB";
    //我方公钥
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC9RtS3TxIykdhAp8Fk+e7Y6Jlty768NDmtt6jIGSnyYpIgG8ZTgeErdlIV8tK4kBMqByRN6J5elRAHydBl6wdIjMM7ycFpUZcYs0NpOJmpyMcC2Dlnj64tMLEwKDXqn9qY31ZSxKh4NcgV5liizVWQj2+cOlO2HT/Gc90pLINLbQIDAQAB";
    //我方私钥
    private static final String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPeEKxsUZBUZ4omCuikb23X44YDCTg0ZZKl55IVPvDXz2eQne/tiCAMXgG5CU2vQ72p4z2z+1oBhoAxeVB/JaA+CfsDOs2ib3Ub1NcYeGawCsbGabPHr8q1Eys9JzRYl+AYKF+1NngZwaYFk3mCmoVRt0zY1e05KnN5VZ0wvUI49AgMBAAECgYBAP/rAiMaCA7oeX+TbDvQk53oB5m5EUDclFxMO1+fPSYFiDC3Oz1+tDci01lq5Pf8n8DxH2s7rfGwDSekkZy+vdEzfpRExCeA7BQytlXObWicmZqjKcLGkKEH0jhGUQWVdiamJmq0SdWoVf2Na55Kx0DM+EjWZmC9Uc+bYFdOxsQJBAPvEw3rPGOzJM36/oGUQHXoWL3gfD86wxEdzk2k6RJwW/+RNZLtUnCWH+LN+Ado7UWD2l7b0caZgzC2Nce6ftYsCQQD7rRvvx1OrsENL+E4FGmYOvVQPLNIkDtqTMGW1/C5fDrn1Sic8iC3ht0uDzDOJMwH7wEtYnDu4JQHqSMm/8RRXAkBoeBsNCIY1Kr+9ZlJt3SP+FtqXo3vxrhOj+mc+kLkLc9e2qg6UVOV+BU/DWxP1tAtuiqQlfIT0HtJaTIjsFUVFAkEAkont3UQzHKGJ3Z8bVm9TgzuLyTYwuRwI+nDQmBDYszJw5jih9eXYyTcfegMY8sbHXd1OQa7eOs8ZeV+eUOs/CwJAXRKo9zGMxHrXQYIQHZZJ6HO7CgA05pYpy6dFhvD8BbQrZO+dwSIZ+YWdihq7ZkpjSoLnTy6jnlvv56suLn2jKg==";
    //合作方渠道
    private static final String CHANNELID = "360jt1";
    //待MD5的字符串
    private static final String MD5 = "17602150745";

    private static final String MOBILE_NO = "13789456258";
    //合作方撞库地址
    private static final String REQUEST_URL = "https://dymapi.shurongdai.cn/market/api/br/360jt/checkUser";

    private static final String REGISTER_URL = "http://paydayloan.panyu.dsqtest.kuainiujinke.com/asset/third/own360";

    /**
     * 测试撞库请求数据并获取返回数据
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
        System.out.println("请求数据:"+requestMap.toString());
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
