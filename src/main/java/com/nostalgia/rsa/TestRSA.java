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

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrFtJBMYfJloKnbkWc84SpaVr00ELgZvlvSfa9h3tZktQ80YeE2dzXfmNaSKqjr5dj8eiSVb0fIVYx5Adz1Ao7HlDlHyRNnT6mYgzuojrD5gBcW2Pz8rWH6/lMUL9ezeujmtk1etiStM5DaJAfjwuuQ2fbJ+3M1X44uN2NjD5GiQIDAQAB";
        String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKsW0kExh8mWgqduRZzzhKlpWvTQQuBm+W9J9r2He1mS1DzRh4TZ3Nd+Y1pIqqOvl2Px6JJVvR8hVjHkB3PUCjseUOUfJE2dPqZiDO6iOsPmAFxbY/PytYfr+UxQv17N66Oa2TV62JK0zkNokB+PC65DZ9sn7czVfji43Y2MPkaJAgMBAAECgYEAp3qNk5gCzolxmKjPqFaRtK0XhrMf5D+pSRHkYZ/wVbzv2iFaQehq0OA+LbEYqWdIEWRLQISBv6mIkQohaXdWEvNXhrlbV1mEynJbFqmvDgt9AC8UktcntgzHvBGbEbcNJgDeg6JlW7mCAyuO/oeMMfGIqUpxGU/A25qR42+5HQECQQDTJYKnzEhnYiiIz6CbTG5shDc0E9yJJhnLaYz7zh54R0iSeVnuI9ajue6xdzxz3L1+Q5wlzS/WddmfwYFkPhYxAkEAz27tBGuL6jHey3NUqfzeNRXZPWqo61d+9vdqH5wz4k7ee/17++P26eUO1ksiRaNoAyJNslFgfYsp0AYBJvwn2QJBAIKZOO9A06feduPoSJbF96b3QI3dmxLZlirS5nj5TK9op+KxXIaHdENgxdrOvX2Mk0h92R8oguZLjofZ0IaIQIECQQCvjDnMHtQXC8N4PI9vGNBY7red0XFJUg/iI/rM653BLWv+VMSjpQZmZXKMCqPjeWniFRraCSJ2vNpS8XHyMz3pAkAPD3TInyNIIidEZfXLf/OBVyafYhbRbHZqCLj7+CETou+Gb7+rADAuKDncBtZTYYnznOfsWcLITKmU9/dCgXyj";
        String content = "{\"code\":\"\",\"flag\":\"S\",\"msg\":\"\"}";

        //加密
        String data = LoanMarketEncryptUtil.rsaEncrypt(content,publicKey);
        //解密
        String s1 = LoanMarketEncryptUtil.rsaDecrypt(data, privateKey);
        System.out.println(s1);
    }

    /**
     * 准备测试数据
     * 加密加签
     * @throws Exception
     */
    @Test
    public void run6() throws Exception{
        String partner_pulbic_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrFtJBMYfJloKnbkWc84SpaVr00ELgZvlvSfa9h3tZktQ80YeE2dzXfmNaSKqjr5dj8eiSVb0fIVYx5Adz1Ao7HlDlHyRNnT6mYgzuojrD5gBcW2Pz8rWH6/lMUL9ezeujmtk1etiStM5DaJAfjwuuQ2fbJ+3M1X44uN2NjD5GiQIDAQAB";
        String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANPmBw2sXIsN5vwJhyKvdEK7id1cSL/96w2qgUwj5AbsbqvXanSRg3fMlJtR404viPlpeiCYxnIoYpYyLxT3oZMaNDJ+LN3glG54dLWf9+qHcugGTDEO22ZmmjNhvFnVTVrx+2dj2COYFi7430jvssLT183K0WoPRI1dNEfDTeDVAgMBAAECgYEAuq0DucAHJ1nwDEo4iw4XVlLxedo7HSkNUtTLY9Caqp7QQQNd/aPUNk48/Th/D/pAqbmKpfzxltCNSdScNdSSufFPKyJZAkQC4j5giCoQ19ETcQmHkCChVIkAHDqcX/lQQf+asBPS6e1Ep+JPiK2I7ZOga0s1+bdQEjEXCvKlzWECQQD/jqoEyj7I0kl3XxX2+fd6rJ25gdKVYCZ0I7H/DpMeJTxIoInPnU+2YqqQoIkguzS2YkILzvxZsXnyzWvWd1x7AkEA1EQAXLSltCqLuZiyzapVgtiDbElr8/WInlazEcPUBxLbg5eYPP3KaO0QqtQJbOpzxllr6W2aPQiNQZF6cO5+7wJBAMFAihNbOUU1uDab4glFF79dv1wj7zHkZs/WmmitBdV7BO5K8EvewwPB8wexTmFBD+iHvzgcyzmsevKAIvcohfcCQHNncUb11C1rAEJsubHFjO4xpupF1NJzSM7FVmAvNuSNpRkbX2KxnM2FLg2icGlt4noRffEQbM4ICzx9yrMBh7MCQChXjreiCDlNm0Koh4kUY+vAOQSjULs5JoeD6GGboMjuL5QLocaAEzbIgymfhLlt4JuZoHYJ+9/OZOH4MPDNVzs=";
        //15989016026422828197803173917
        String content = "{\"hitType\":\"MD5\",\"hitValue\":\"6c10da40e97aa3abe80d8f3e8e4a5c0a\",\"ip\":\"127.0.0.1\"}";
        //加密
        String requestData = LoanMarketEncryptUtil.rsaEncrypt(content,partner_pulbic_key);
        //加签
        System.out.println("密文:"+requestData);
        String sign = LoanMarketSignUtil.rsaSign(private_key,requestData);
        System.out.println("签名:"+sign);
        System.out.println("========================");



    }

    /**
     * 准备测试数据
     * 加密加签
     * @throws Exception
     */
    @Test
    public void run66() throws Exception{
        String partner_pulbic_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrFtJBMYfJloKnbkWc84SpaVr00ELgZvlvSfa9h3tZktQ80YeE2dzXfmNaSKqjr5dj8eiSVb0fIVYx5Adz1Ao7HlDlHyRNnT6mYgzuojrD5gBcW2Pz8rWH6/lMUL9ezeujmtk1etiStM5DaJAfjwuuQ2fbJ+3M1X44uN2NjD5GiQIDAQAB";
        String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANPmBw2sXIsN5vwJhyKvdEK7id1cSL/96w2qgUwj5AbsbqvXanSRg3fMlJtR404viPlpeiCYxnIoYpYyLxT3oZMaNDJ+LN3glG54dLWf9+qHcugGTDEO22ZmmjNhvFnVTVrx+2dj2COYFi7430jvssLT183K0WoPRI1dNEfDTeDVAgMBAAECgYEAuq0DucAHJ1nwDEo4iw4XVlLxedo7HSkNUtTLY9Caqp7QQQNd/aPUNk48/Th/D/pAqbmKpfzxltCNSdScNdSSufFPKyJZAkQC4j5giCoQ19ETcQmHkCChVIkAHDqcX/lQQf+asBPS6e1Ep+JPiK2I7ZOga0s1+bdQEjEXCvKlzWECQQD/jqoEyj7I0kl3XxX2+fd6rJ25gdKVYCZ0I7H/DpMeJTxIoInPnU+2YqqQoIkguzS2YkILzvxZsXnyzWvWd1x7AkEA1EQAXLSltCqLuZiyzapVgtiDbElr8/WInlazEcPUBxLbg5eYPP3KaO0QqtQJbOpzxllr6W2aPQiNQZF6cO5+7wJBAMFAihNbOUU1uDab4glFF79dv1wj7zHkZs/WmmitBdV7BO5K8EvewwPB8wexTmFBD+iHvzgcyzmsevKAIvcohfcCQHNncUb11C1rAEJsubHFjO4xpupF1NJzSM7FVmAvNuSNpRkbX2KxnM2FLg2icGlt4noRffEQbM4ICzx9yrMBh7MCQChXjreiCDlNm0Koh4kUY+vAOQSjULs5JoeD6GGboMjuL5QLocaAEzbIgymfhLlt4JuZoHYJ+9/OZOH4MPDNVzs=";
        //15989016026422828197803173917
        /*String content = "{\"hitType\":\"MD5\",\"hitValue\":\"3e9ab315b16e008bbebc2d00acb2b9b0\",\"ip\":\"127.0.0.1\"}";*/
        String content = "{\"flowNo\":\"P5910233278295580888\",\"mobileNo\":\"13530223301\"}";
        //加密
        String requestData = LoanMarketEncryptUtil.rsaEncrypt(content,partner_pulbic_key);
        System.out.println("requestData:"+requestData);
        //加签
        String sign = LoanMarketSignUtil.rsaSign(private_key,requestData);
        System.out.println("sign:"+sign);
        System.out.println("========================");



    }

    /**
     * 获取MD5数据
     * @throws Exception
     */
    @Test
    public void run33() throws Exception{
        String content = "13530227101320922197206250085";
        System.out.println(MD5Util.getMD5String(content));
    }

    /**
     * 验证返回数据
     * 验签解密
     * @throws Exception
     */
    @Test
    public void run7() throws Exception {
        String pulbic_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrFtJBMYfJloKnbkWc84SpaVr00ELgZvlvSfa9h3tZktQ80YeE2dzXfmNaSKqjr5dj8eiSVb0fIVYx5Adz1Ao7HlDlHyRNnT6mYgzuojrD5gBcW2Pz8rWH6/lMUL9ezeujmtk1etiStM5DaJAfjwuuQ2fbJ+3M1X44uN2NjD5GiQIDAQAB";
        String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANPmBw2sXIsN5vwJhyKvdEK7id1cSL/96w2qgUwj5AbsbqvXanSRg3fMlJtR404viPlpeiCYxnIoYpYyLxT3oZMaNDJ+LN3glG54dLWf9+qHcugGTDEO22ZmmjNhvFnVTVrx+2dj2COYFi7430jvssLT183K0WoPRI1dNEfDTeDVAgMBAAECgYEAuq0DucAHJ1nwDEo4iw4XVlLxedo7HSkNUtTLY9Caqp7QQQNd/aPUNk48/Th/D/pAqbmKpfzxltCNSdScNdSSufFPKyJZAkQC4j5giCoQ19ETcQmHkCChVIkAHDqcX/lQQf+asBPS6e1Ep+JPiK2I7ZOga0s1+bdQEjEXCvKlzWECQQD/jqoEyj7I0kl3XxX2+fd6rJ25gdKVYCZ0I7H/DpMeJTxIoInPnU+2YqqQoIkguzS2YkILzvxZsXnyzWvWd1x7AkEA1EQAXLSltCqLuZiyzapVgtiDbElr8/WInlazEcPUBxLbg5eYPP3KaO0QqtQJbOpzxllr6W2aPQiNQZF6cO5+7wJBAMFAihNbOUU1uDab4glFF79dv1wj7zHkZs/WmmitBdV7BO5K8EvewwPB8wexTmFBD+iHvzgcyzmsevKAIvcohfcCQHNncUb11C1rAEJsubHFjO4xpupF1NJzSM7FVmAvNuSNpRkbX2KxnM2FLg2icGlt4noRffEQbM4ICzx9yrMBh7MCQChXjreiCDlNm0Koh4kUY+vAOQSjULs5JoeD6GGboMjuL5QLocaAEzbIgymfhLlt4JuZoHYJ+9/OZOH4MPDNVzs=";


        String responseSign = "nD6JffXEcXYmHbjvVm5jxLaNFsNvnopFD8RNu4mjNxWNdTMyzJud3H3qWnbJEShaWVCzx258UvJ7f/gZTxk0WQWKN8IMxCFBgL9F7Ap+QgNHp4vcek+3DQiqMT4Pcaor4XZaO8THbbrAe5XSzZe8BSkRfPsbN4oKXsmNzBYc51Q=";
        String responseData = "p9uGOKZsjUDjD96dqQcxYKGaQtFVI5/1HAhtERyXMCdnw1ILv2R7YKvEjZJ2lOuG1MusVy2XvBaIuiFetgkYfLuuGAWo9CrNHGoq1BTXC0GZO/WAKzMMl/eOdKlRzk3GXQioSovzjyJ8c1zPm1ycf0yxDQtxa712RPpggWW9QVw=";

        //加签并比较数据是否一致
        /*String rsaSign = LoanMarketSignUtil.rsaSign(partner_private_key, responseData);
        System.out.println(rsaSign);
        System.out.println(responseSign);
        System.out.println("是否相等:"+ rsaSign == responseSign );*/


        //解签
        boolean b = LoanMarketSignUtil.rsaVerifySign(pulbic_key, responseData, responseSign);
        System.out.println(b);
        //解密
        String s = LoanMarketEncryptUtil.rsaDecrypt(responseData, private_key);
        System.out.println(s);

    }

}
