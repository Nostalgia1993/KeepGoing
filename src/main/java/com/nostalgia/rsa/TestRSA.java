package com.nostalgia.rsa;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import sun.misc.BASE64Encoder;

import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author liunian
 * @createTime 2019/8/21
 * @description
 */
public class TestRSA {


    @Test
    public void run() throws Exception{
        Map<String, String> requestDate = new HashMap<>(2);
        requestDate.put("requestId", UUID.randomUUID().toString());
        requestDate.put("md5", "32921525703352320");
        String data = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQ9twqyPiTn1KH/c+xLCSCa3JQS6WmXp1B0gp3nzvg+NIdDsggoN+ScO0jH1640LqJHpX563oe74rT4wZHHLxunOonwO4m0wmIC8VyjdqHALSb9rKkvS693uIVcUn8pcwO66rMec9/QFdrWjrlnfqqyofjoG7HllPa7NjONPB7QwIDAQAB";
        LoanMarketEncryptUtil.rsaEncrypt(JSONObject.toJSONString(requestDate), data);
        System.out.println(data);
    }


    @Test
    public void run2() throws Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3hCsbFGQVGeKJgropG9t1+OGAwk4NGWSpeeSFT7w189nkJ3v7YggDF4BuQlNr0O9qeM9s/taAYaAMXlQfyWgPgn7AzrNom91G9TXGHhmsArGxmmzx6/KtRMrPSc0WJfgGChftTZ4GcGmBZN5gpqFUbdM2NXtOSpzeVWdML1COPQIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPeEKxsUZBUZ4omCuikb23X44YDCTg0ZZKl55IVPvDXz2eQne/tiCAMXgG5CU2vQ72p4z2z+1oBhoAxeVB/JaA+CfsDOs2ib3Ub1NcYeGawCsbGabPHr8q1Eys9JzRYl+AYKF+1NngZwaYFk3mCmoVRt0zY1e05KnN5VZ0wvUI49AgMBAAECgYBAP/rAiMaCA7oeX+TbDvQk53oB5m5EUDclFxMO1+fPSYFiDC3Oz1+tDci01lq5Pf8n8DxH2s7rfGwDSekkZy+vdEzfpRExCeA7BQytlXObWicmZqjKcLGkKEH0jhGUQWVdiamJmq0SdWoVf2Na55Kx0DM+EjWZmC9Uc+bYFdOxsQJBAPvEw3rPGOzJM36/oGUQHXoWL3gfD86wxEdzk2k6RJwW/+RNZLtUnCWH+LN+Ado7UWD2l7b0caZgzC2Nce6ftYsCQQD7rRvvx1OrsENL+E4FGmYOvVQPLNIkDtqTMGW1/C5fDrn1Sic8iC3ht0uDzDOJMwH7wEtYnDu4JQHqSMm/8RRXAkBoeBsNCIY1Kr+9ZlJt3SP+FtqXo3vxrhOj+mc+kLkLc9e2qg6UVOV+BU/DWxP1tAtuiqQlfIT0HtJaTIjsFUVFAkEAkont3UQzHKGJ3Z8bVm9TgzuLyTYwuRwI+nDQmBDYszJw5jih9eXYyTcfegMY8sbHXd1OQa7eOs8ZeV+eUOs/CwJAXRKo9zGMxHrXQYIQHZZJ6HO7CgA05pYpy6dFhvD8BbQrZO+dwSIZ+YWdihq7ZkpjSoLnTy6jnlvv56suLn2jKg==";

        String responseData = "g/y+rjjHCvyOmj47Px1hlwevFXwBnDnNuhm2Un0XP3skQQPJebufJq0G3bR526GFNsHdDjOM0HoRvjIlRtf5pNauX5VOJ1zbaekaQdQ43HVUnSr10rIpFBaGlOheh1oWDt5z0gXyUFCU91Ui63k3+6Pva+5Y1/rZSza4Hc2hhB4=";

        /*String content = "我是内容";
        String s = LoanMarketEncryptUtil.rsaEncrypt(content, publicKey);
        String s1 = LoanMarketEncryptUtil.rsaDecrypt(s, privateKey);
        System.out.println(s1);*/

        System.out.println(LoanMarketEncryptUtil.rsaDecrypt(responseData, privateKey));

    }

    @Test
    public void run3() throws Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3hCsbFGQVGeKJgropG9t1+OGAwk4NGWSpeeSFT7w189nkJ3v7YggDF4BuQlNr0O9qeM9s/taAYaAMXlQfyWgPgn7AzrNom91G9TXGHhmsArGxmmzx6/KtRMrPSc0WJfgGChftTZ4GcGmBZN5gpqFUbdM2NXtOSpzeVWdML1COPQIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPeEKxsUZBUZ4omCuikb23X44YDCTg0ZZKl55IVPvDXz2eQne/tiCAMXgG5CU2vQ72p4z2z+1oBhoAxeVB/JaA+CfsDOs2ib3Ub1NcYeGawCsbGabPHr8q1Eys9JzRYl+AYKF+1NngZwaYFk3mCmoVRt0zY1e05KnN5VZ0wvUI49AgMBAAECgYBAP/rAiMaCA7oeX+TbDvQk53oB5m5EUDclFxMO1+fPSYFiDC3Oz1+tDci01lq5Pf8n8DxH2s7rfGwDSekkZy+vdEzfpRExCeA7BQytlXObWicmZqjKcLGkKEH0jhGUQWVdiamJmq0SdWoVf2Na55Kx0DM+EjWZmC9Uc+bYFdOxsQJBAPvEw3rPGOzJM36/oGUQHXoWL3gfD86wxEdzk2k6RJwW/+RNZLtUnCWH+LN+Ado7UWD2l7b0caZgzC2Nce6ftYsCQQD7rRvvx1OrsENL+E4FGmYOvVQPLNIkDtqTMGW1/C5fDrn1Sic8iC3ht0uDzDOJMwH7wEtYnDu4JQHqSMm/8RRXAkBoeBsNCIY1Kr+9ZlJt3SP+FtqXo3vxrhOj+mc+kLkLc9e2qg6UVOV+BU/DWxP1tAtuiqQlfIT0HtJaTIjsFUVFAkEAkont3UQzHKGJ3Z8bVm9TgzuLyTYwuRwI+nDQmBDYszJw5jih9eXYyTcfegMY8sbHXd1OQa7eOs8ZeV+eUOs/CwJAXRKo9zGMxHrXQYIQHZZJ6HO7CgA05pYpy6dFhvD8BbQrZO+dwSIZ+YWdihq7ZkpjSoLnTy6jnlvv56suLn2jKg==";

        String responseData = "aj/+ISmrJR6AirBKD8JwDOhriH7Dh5lj054TXUt4gJQZ+NenMCH5ZN5+uYkiVW831/KDwYj/Oke2qvOTZ61AN4BJ7pNMcmN/qr6KBcvKcQ20VXOiMqo5T2jFvcESaK5CRyiIkU/wHXPeC0jcsvzizExcUNe2imLLtpx4UOHQKso=";

        /*String content = "我是内容";
        String s = LoanMarketEncryptUtil.rsaEncrypt(content, publicKey);
        String s1 = LoanMarketEncryptUtil.rsaDecrypt(s, privateKey);
        System.out.println(s1);*/

        System.out.println(LoanMarketEncryptUtil.rsaDecrypt(responseData, privateKey));

    }

    /**
     * 先验签再解密
     * @throws Exception
     */
    @Test
    public void run4() throws Exception{
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3hCsbFGQVGeKJgropG9t1+OGAwk4NGWSpeeSFT7w189nkJ3v7YggDF4BuQlNr0O9qeM9s/taAYaAMXlQfyWgPgn7AzrNom91G9TXGHhmsArGxmmzx6/KtRMrPSc0WJfgGChftTZ4GcGmBZN5gpqFUbdM2NXtOSpzeVWdML1COPQIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPeEKxsUZBUZ4omCuikb23X44YDCTg0ZZKl55IVPvDXz2eQne/tiCAMXgG5CU2vQ72p4z2z+1oBhoAxeVB/JaA+CfsDOs2ib3Ub1NcYeGawCsbGabPHr8q1Eys9JzRYl+AYKF+1NngZwaYFk3mCmoVRt0zY1e05KnN5VZ0wvUI49AgMBAAECgYBAP/rAiMaCA7oeX+TbDvQk53oB5m5EUDclFxMO1+fPSYFiDC3Oz1+tDci01lq5Pf8n8DxH2s7rfGwDSekkZy+vdEzfpRExCeA7BQytlXObWicmZqjKcLGkKEH0jhGUQWVdiamJmq0SdWoVf2Na55Kx0DM+EjWZmC9Uc+bYFdOxsQJBAPvEw3rPGOzJM36/oGUQHXoWL3gfD86wxEdzk2k6RJwW/+RNZLtUnCWH+LN+Ado7UWD2l7b0caZgzC2Nce6ftYsCQQD7rRvvx1OrsENL+E4FGmYOvVQPLNIkDtqTMGW1/C5fDrn1Sic8iC3ht0uDzDOJMwH7wEtYnDu4JQHqSMm/8RRXAkBoeBsNCIY1Kr+9ZlJt3SP+FtqXo3vxrhOj+mc+kLkLc9e2qg6UVOV+BU/DWxP1tAtuiqQlfIT0HtJaTIjsFUVFAkEAkont3UQzHKGJ3Z8bVm9TgzuLyTYwuRwI+nDQmBDYszJw5jih9eXYyTcfegMY8sbHXd1OQa7eOs8ZeV+eUOs/CwJAXRKo9zGMxHrXQYIQHZZJ6HO7CgA05pYpy6dFhvD8BbQrZO+dwSIZ+YWdihq7ZkpjSoLnTy6jnlvv56suLn2jKg==";
        String partnerPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQ9twqyPiTn1KH/c+xLCSCa3JQS6WmXp1B0gp3nzvg+NIdDsggoN+ScO0jH1640LqJHpX563oe74rT4wZHHLxunOonwO4m0wmIC8VyjdqHALSb9rKkvS693uIVcUn8pcwO66rMec9/QFdrWjrlnfqqyofjoG7HllPa7NjONPB7QwIDAQAB";

        String responseData = "4G4xa2sEKb1g+rkn/LnG/tquzgxInf2v8oXC0DEo8rYGl/CXEsyurNktBUvMEJcB6svF6saIVqI+M0/R6HZkxZAJdkekzZKfSo2E/+gnmVwts3/r6SgJGDtzVVNVre18jSp4Om453eA4zz4etykiOwdoPRdUr4oyCsmmu7i3MMI=";
        String sign = "YiIVHcSHQZ5zrkTDOdPmrfCaS6zKEg0WnhlhhayQRL5I5avpvYDJJ3kGwmWqqPRSv/CxYMVUK5BrXsrxTVlB4gLISXF7J9bzdXbWakQRICgydXV96hHaFNO5uajBm8UyRNAKJ1wjN5dygrkEAitdDmbE/bKbySwa01W/d1KfbfI=";

        System.out.println(LoanMarketEncryptUtil.rsaDecrypt(responseData, privateKey));

        //解签
        boolean b = LoanMarketSignUtil.rsaVerifySign(partnerPublicKey, responseData,sign);
        System.out.println(b);
    }

    /**
     * 验证公私钥
     * @throws Exception
     */
    @Test
    public void run5() throws Exception{
        /*String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDS4Z5XqcOzi6bw/6bU7IQYf6kEVIyVBmux+HAlUYQpm+PJhO3FiNsv7a3jEL4hqZs9tQczOZe9LRLQzPGyL/0+/T/9zTW652Bd106uScYXG4DvrPzMexg7kNWhsqWIQGtfTJ/Z2qhHQgSHTG4AS5wsLeeEQQBrbV5oEiFOQhHSSQIDAQAB";
        String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANLhnlepw7OLpvD/ptTshBh/qQRUjJUGa7H4cCVRhCmb48mE7cWI2y/treMQviGpmz21BzM5l70tEtDM8bIv/T79P/3NNbrnYF3XTq5JxhcbgO+s/Mx7GDuQ1aGypYhAa19Mn9naqEdCBIdMbgBLnCwt54RBAGttXmgSIU5CEdJJAgMBAAECgYEAuMdrKGMfkOZwXEGWnIG16YWKwrmXCUm7+hC3q2t3A8KN4NkyQuD9NkzsDcdw4iwsU/CYo4D2fZPOJdk+eyTjn8IdwMCGH8uCZGvqJLHEk+cW1myB/jwXQzRc3qlyyVFE/jQwiucBk4E8RZQHIf9cMIP6A9HnGAl9VYh/cJGCVtECQQD94V8G1O4yc8pEgcPRiaVpIH3f//hnfyO9ONAAoXOeJZt924ts7YKtZ7gVd1C+8u2Q6p6f7CulJvvGfr5dKaS1AkEA1KRX/6eobwfsDL3jx1QaqRZi2f+loybmfwWbxksXy1n79Ipdj6FkB724GUQKZ9Cj8CiAYTbewqIpGdbinMSnxQJBAK/nV1AEeIW8dIjC4EpudI1CVfS+Bf6vuLOCiZvmQZVxuSqa0x/F8KT1GDbHVMr4xmGCLiXgHN1xBUGiz4L9N4ECQQDJLcNjyQd+JIybcXxzNYsTtm5HuarINSGVw4ShkqIsbjIGJnJmVVcCS+hFXy5JEghISslLMFKI6krge4FiuFvRAkBa98MOPa945JM3tbHP8m5+gCsBxnMsFGh9zzNd1m7L42yirHXKnTuFGKK7QPq4A+/Lf4JtIqFDC846jB5ZvcIb";*/
        /*Map<String, String> keyPairMap = LoanMarketEncryptUtil.genKeyPairStringMap();
        System.out.println(keyPairMap);*/
        /*String publicKey = keyPairMap.get(LoanMarketEncryptUtil.PUBLIC_KEY);
        String privateKey = keyPairMap.get(LoanMarketEncryptUtil.PRIVATE_KEY);
        System.out.println("publicKey:"+publicKey);
        System.out.println("privateKey:"+privateKey);*/
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3hCsbFGQVGeKJgropG9t1+OGAwk4NGWSpeeSFT7w189nkJ3v7YggDF4BuQlNr0O9qeM9s/taAYaAMXlQfyWgPgn7AzrNom91G9TXGHhmsArGxmmzx6/KtRMrPSc0WJfgGChftTZ4GcGmBZN5gpqFUbdM2NXtOSpzeVWdML1COPQIDAQAB";
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAPeEKxsUZBUZ4omCuikb23X44YDCTg0ZZKl55IVPvDXz2eQne/tiCAMXgG5CU2vQ72p4z2z+1oBhoAxeVB/JaA+CfsDOs2ib3Ub1NcYeGawCsbGabPHr8q1Eys9JzRYl+AYKF+1NngZwaYFk3mCmoVRt0zY1e05KnN5VZ0wvUI49AgMBAAECgYBAP/rAiMaCA7oeX+TbDvQk53oB5m5EUDclFxMO1+fPSYFiDC3Oz1+tDci01lq5Pf8n8DxH2s7rfGwDSekkZy+vdEzfpRExCeA7BQytlXObWicmZqjKcLGkKEH0jhGUQWVdiamJmq0SdWoVf2Na55Kx0DM+EjWZmC9Uc+bYFdOxsQJBAPvEw3rPGOzJM36/oGUQHXoWL3gfD86wxEdzk2k6RJwW/+RNZLtUnCWH+LN+Ado7UWD2l7b0caZgzC2Nce6ftYsCQQD7rRvvx1OrsENL+E4FGmYOvVQPLNIkDtqTMGW1/C5fDrn1Sic8iC3ht0uDzDOJMwH7wEtYnDu4JQHqSMm/8RRXAkBoeBsNCIY1Kr+9ZlJt3SP+FtqXo3vxrhOj+mc+kLkLc9e2qg6UVOV+BU/DWxP1tAtuiqQlfIT0HtJaTIjsFUVFAkEAkont3UQzHKGJ3Z8bVm9TgzuLyTYwuRwI+nDQmBDYszJw5jih9eXYyTcfegMY8sbHXd1OQa7eOs8ZeV+eUOs/CwJAXRKo9zGMxHrXQYIQHZZJ6HO7CgA05pYpy6dFhvD8BbQrZO+dwSIZ+YWdihq7ZkpjSoLnTy6jnlvv56suLn2jKg==";
        String content = "{\"code\":\"\",\"flag\":\"S\",\"msg\":\"\"}";

        /*String s = LoanMarketEncryptUtil.rsaEncrypt(content, publicKey);
        System.out.println(s);
        System.out.println("==============");
        String s1 = LoanMarketEncryptUtil.rsaDecrypt(s, privateKey);
        System.out.println(s1);*/
        //解密
        String data = "aj/+ISmrJR6AirBKD8JwDOhriH7Dh5lj054TXUt4gJQZ+NenMCH5ZN5+uYkiVW831/KDwYj/Oke2qvOTZ61AN4BJ7pNMcmN/qr6KBcvKcQ20VXOiMqo5T2jFvcESaK5CRyiIkU/wHXPeC0jcsvzizExcUNe2imLLtpx4UOHQKso=";
        String s1 = LoanMarketEncryptUtil.rsaDecrypt(data, privateKey);
        System.out.println(s1);
    }

    /**
     * 准备测试数据
     * @throws Exception
     */
    @Test
    public void run6() throws Exception{
        String partner_pulbic_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3hCsbFGQVGeKJgropG9t1+OGAwk4NGWSpeeSFT7w189nkJ3v7YggDF4BuQlNr0O9qeM9s/taAYaAMXlQfyWgPgn7AzrNom91G9TXGHhmsArGxmmzx6/KtRMrPSc0WJfgGChftTZ4GcGmBZN5gpqFUbdM2NXtOSpzeVWdML1COPQIDAQAB";
        String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAL1G1LdPEjKR2ECnwWT57tjomW3Lvrw0Oa23qMgZKfJikiAbxlOB4St2UhXy0riQEyoHJE3onl6VEAfJ0GXrB0iMwzvJwWlRlxizQ2k4manIxwLYOWePri0wsTAoNeqf2pjfVlLEqHg1yBXmWKLNVZCPb5w6U7YdP8Zz3Sksg0ttAgMBAAECgYAdT6u/W3Jg/G71zETJw162noasFyJJePj5qvhrTGJPk+43JLX41qMtHNynY3w4cq9VEdgQbJah5QmfeyRXtCbjU5SQk+9c0g5wsuLX93KSpmVzgHkc08O0B15CtKmwp8ztvM9OWHTehkzChkWuWS7z+R5DWzmcDk+KNIAIBsfQLQJBAPos9EezhTggBhNvVmN4wFufVYdKedRC/KMNM5GZ6f0Bsr8dW/ugEX/36w/A9XugFl53FQBfetPvo5l2fSxoBzcCQQDBrutZ//K+gA8Ixb/9MjaQCZZQSYa4QJddevhnLZAmMzAW9tKE2LPqxta9dstW30uGWUA7uHftYZQIbd9peMx7AkBMT+An6vvNFf+keAbbCt9qU10MisxE0jYsKn+7fz6f3Z+/ql3/kGEmLuK2CH8ZOcj5AcwXNAjMk0HNMxaVsBnbAkAWv0Vy54WJ7B5X6Gm5Afm4hve5bDk/UI62cufTrl08r0xZlhl5cr4Gt92mmNoe1NDY8YiCuxKStaAeMVFI4OAbAkBrUDiu/DSId8KVpp+N8iL2ulnZJMyqLmvqsQT6xJgRw8gmA8NmHSJNmnbBecX8UWAgUdtwiHzk6oz/Fb+fl1Pr";
        //15989016026422828197803173917
        String content = "{\"code\":\"\",\"flag\":\"S\",\"msg\":\"\"}";
        //加密
        String requestData = LoanMarketEncryptUtil.rsaEncrypt(content,partner_pulbic_key);
        //加签
        System.out.println("密文:"+requestData);
        System.out.println("WDBgdM6UqtLslc8HG3EiWE1M3YkRW8daxI/+T1ibW/MVvBCB8j4rbx+dpzpi1/BaLuhSPH/TI+3HoXE9t4jfuGG7j4kBzA4rNytUu0Z7SXH3nmhDwo0UvQB8cqS0Q/YtExIxCDCVaQS7Elm05SvMGvwrn+iGOjxkcX901A5ZKZs=");
        /*String sign = LoanMarketSignUtil.rsaSign(private_key,requestData);
        System.out.println("签名:"+sign);
        System.out.println("========================");*/



    }

    /**
     * 获取MD5数据
     * @throws Exception
     */
    @Test
    public void run33() throws Exception{
        String content = "15989016026422828197803173917";
        System.out.println(MD5Util.getMD5String(content));
    }

    /**
     * 验证返回数据
     * @throws Exception
     */
    @Test
    public void run7() throws Exception {
        String partner_pulbic_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDS4Z5XqcOzi6bw/6bU7IQYf6kEVIyVBmux+HAlUYQpm+PJhO3FiNsv7a3jEL4hqZs9tQczOZe9LRLQzPGyL/0+/T/9zTW652Bd106uScYXG4DvrPzMexg7kNWhsqWIQGtfTJ/Z2qhHQgSHTG4AS5wsLeeEQQBrbV5oEiFOQhHSSQIDAQAB";
        String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAL1G1LdPEjKR2ECnwWT57tjomW3Lvrw0Oa23qMgZKfJikiAbxlOB4St2UhXy0riQEyoHJE3onl6VEAfJ0GXrB0iMwzvJwWlRlxizQ2k4manIxwLYOWePri0wsTAoNeqf2pjfVlLEqHg1yBXmWKLNVZCPb5w6U7YdP8Zz3Sksg0ttAgMBAAECgYAdT6u/W3Jg/G71zETJw162noasFyJJePj5qvhrTGJPk+43JLX41qMtHNynY3w4cq9VEdgQbJah5QmfeyRXtCbjU5SQk+9c0g5wsuLX93KSpmVzgHkc08O0B15CtKmwp8ztvM9OWHTehkzChkWuWS7z+R5DWzmcDk+KNIAIBsfQLQJBAPos9EezhTggBhNvVmN4wFufVYdKedRC/KMNM5GZ6f0Bsr8dW/ugEX/36w/A9XugFl53FQBfetPvo5l2fSxoBzcCQQDBrutZ//K+gA8Ixb/9MjaQCZZQSYa4QJddevhnLZAmMzAW9tKE2LPqxta9dstW30uGWUA7uHftYZQIbd9peMx7AkBMT+An6vvNFf+keAbbCt9qU10MisxE0jYsKn+7fz6f3Z+/ql3/kGEmLuK2CH8ZOcj5AcwXNAjMk0HNMxaVsBnbAkAWv0Vy54WJ7B5X6Gm5Afm4hve5bDk/UI62cufTrl08r0xZlhl5cr4Gt92mmNoe1NDY8YiCuxKStaAeMVFI4OAbAkBrUDiu/DSId8KVpp+N8iL2ulnZJMyqLmvqsQT6xJgRw8gmA8NmHSJNmnbBecX8UWAgUdtwiHzk6oz/Fb+fl1Pr";
        String partner_private_key = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANLhnlepw7OLpvD/ptTshBh/qQRUjJUGa7H4cCVRhCmb48mE7cWI2y/treMQviGpmz21BzM5l70tEtDM8bIv/T79P/3NNbrnYF3XTq5JxhcbgO+s/Mx7GDuQ1aGypYhAa19Mn9naqEdCBIdMbgBLnCwt54RBAGttXmgSIU5CEdJJAgMBAAECgYEAuMdrKGMfkOZwXEGWnIG16YWKwrmXCUm7+hC3q2t3A8KN4NkyQuD9NkzsDcdw4iwsU/CYo4D2fZPOJdk+eyTjn8IdwMCGH8uCZGvqJLHEk+cW1myB/jwXQzRc3qlyyVFE/jQwiucBk4E8RZQHIf9cMIP6A9HnGAl9VYh/cJGCVtECQQD94V8G1O4yc8pEgcPRiaVpIH3f//hnfyO9ONAAoXOeJZt924ts7YKtZ7gVd1C+8u2Q6p6f7CulJvvGfr5dKaS1AkEA1KRX/6eobwfsDL3jx1QaqRZi2f+loybmfwWbxksXy1n79Ipdj6FkB724GUQKZ9Cj8CiAYTbewqIpGdbinMSnxQJBAK/nV1AEeIW8dIjC4EpudI1CVfS+Bf6vuLOCiZvmQZVxuSqa0x/F8KT1GDbHVMr4xmGCLiXgHN1xBUGiz4L9N4ECQQDJLcNjyQd+JIybcXxzNYsTtm5HuarINSGVw4ShkqIsbjIGJnJmVVcCS+hFXy5JEghISslLMFKI6krge4FiuFvRAkBa98MOPa945JM3tbHP8m5+gCsBxnMsFGh9zzNd1m7L42yirHXKnTuFGKK7QPq4A+/Lf4JtIqFDC846jB5ZvcIb";


        String responseData = "PKIrMbFSditwKvVGjkaDoITyi39xxg6sD074++5w321EwJLb206xHvq1lJiKU1gkCLG3mrXiZ6hUpB3Fv9iBPjfpLNtgX0v2j19BsklgepA5+RTgewWwxPldmL9k+WKSdMj4j92RKDzfKsYQxljqkkelSwXo5xkh82iKuAbAKig=";
        String responseSign = "LKigldp4VsZhieJ11ARJNiJ7+olWRJyFDErhKJTZCJiYmwY3k2zB3C90R9H8ZYn1u70rnqkVwd/tCbCsyBHx/PRGgNN2SBlNFvoevFCYn78BUgjG6wSACnGnAbLJ932BG1arJqSvdgCSHflozz2KPd7HCShtrctotS2MTw5Qv+M=";

        //加签并比较数据是否一致
        String rsaSign = LoanMarketSignUtil.rsaSign(partner_private_key, responseData);
        System.out.println(rsaSign);
        System.out.println(responseSign);
        System.out.println("是否相等:"+ rsaSign == responseSign );


        //解签
        boolean b = LoanMarketSignUtil.rsaVerifySign(partner_pulbic_key, responseData, responseSign);
        System.out.println(b);
        //解密
        String s = LoanMarketEncryptUtil.rsaDecrypt(responseData, private_key);
        System.out.println(s);

    }

}
