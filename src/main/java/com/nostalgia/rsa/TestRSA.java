package com.nostalgia.rsa;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

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
        LoanMarketEncryptUtil.rsaEncrypt(JSON.toJSONString(requestDate), data);
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

        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDlziudTzcE/uk/qkkbbdGspipRrQuEtQuCyO5kJD97i3DbJ5WWRNRCfAKQQh5J+NJR1kdEoVnWafFmhIwxlQOUP0JkISxltuYuQfChSNG6p5NVu5UgiLkLeAkr7QJA4hr8+t3afiIf5QXZyZZ2J6bBqhrivC1bbBpHC6ncXLXvswIDAQAB";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOXOK51PNwT+6T+qSRtt0aymKlGtC4S1C4LI7mQkP3uLcNsnlZZE1EJ8ApBCHkn40lHWR0ShWdZp8WaEjDGVA5Q/QmQhLGW25i5B8KFI0bqnk1W7lSCIuQt4CSvtAkDiGvz63dp+Ih/lBdnJlnYnpsGqGuK8LVtsGkcLqdxcte+zAgMBAAECgYAQaRCkQyvip3FwonBmDQmUEqmi+4B/EY6o4EBl1lDSObrta347JN8jgEeOlaokDii2v16HgB4yOY6Li5uXTtTadp5uCzBpLqJpO6P5HtX5qM5lzQQCv64HAM6ohcnjgoGGQHlR17+6uEOe9FAV5MU4KfyOukpx9gzChKI8wgiuAQJBAPyh7qgyOMM9+LgF2fENKJFivOQ+1tChpzKyj6KPtrRugO24E9XHwhOug1aV0+cO+Xg28VONfXMmDDytFD/7jOECQQDo3lgQeUeysdf/WTuXtToxwYVmVdz9oN9NV9nACCFZmMA1bkrBpe/6kSUA1vDBhEHknQL52IX8hlv9jR2mRtsTAkEA5YrQyRyQvL2jLrmKU96L3MWlMZHzJy+qNoNNxPvlmz3IgbY+t4DAU5e+GD8cgZX2kAcD8NHfiW+psLvmaVhLoQJBAK9VolcdChgJAgpYZJ9Qq/WEsW2hHti1BQ1WJTUKqhmtAqP4XD88Mtml6YedTv9WFssMUY5PMms1uxPI6dclqJMCQBfO7+A4luyedFw905tZANZAelL/gYBRZ02tE1gnwIi6IuafC58XYB2Dj8KENI1Ov4kcEbWlGVYFHPZjwKrGOcM=";
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
        String partner_pulbic_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDpV1me5cT1ZMnq7J0k5h5BJOAjWnlIfcoQbQwJ4UFR1zIsOovSm+x2Z3YoUKVGvGdwUGjYYvT5/XgBPCcFZcPO7vBjPU+O8jnXEoJHNJfqJwlXS1fWTkyB1BRNbra6IeNtpCY1zz02NPaJ4V+0ALkNTo/VWjn/kxnPU7dmj/dTYwIDAQAB";
        String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAOlXWZ7lxPVkyersnSTmHkEk4CNaeUh9yhBtDAnhQVHXMiw6i9Kb7HZndihQpUa8Z3BQaNhi9Pn9eAE8JwVlw87u8GM9T47yOdcSgkc0l+onCVdLV9ZOTIHUFE1utroh422kJjXPPTY09onhX7QAuQ1Oj9VaOf+TGc9Tt2aP91NjAgMBAAECgYBPR9F4boMECXGdczVVQyaGZbwN5wCMQ8jy2cocVT93ShGO+3lkXnvyIub/fZ8aMItImtl0o/KuOZObf8+WQuRK9a4Wsr65RQSfR6xCPVgxXdqndt9oNyoJZazomE4n51uvBC6BdA91ooF7EqKCPIAPOKlygu+V+zB/2zgMJzu4GQJBAP0xKSR9z/XY7qrkQhr7QgZmwDAdDqGep7E5Cc+ItO3+y0So2vRy6YKzeC3JXIelIC++HhNF8bcGji6rrpnMo50CQQDr7dSsfcXjDWFBjnoqVbl/p/131oywb4hloGijntMpnqMiIvWhSLjnqdgcz6S1ZfiKOfeb6fAY0acrvPAhw6L/AkA0F+VLKMec4aFZb9VaD9Ap2QI55ACaqDYAdKfcF1iCjyXrXoKOQQZiaeKUKRXsosDYkdlGReHRsnuWhqRJ6JzRAkAvJftPcV8fjef2uuttFG6atU6xKT46cD+Y16KxuCbI9XvycXwW/Dp/iXC36UMoQTWXIhh6nxitTRCUbBCtHrSvAkBCZohvT3+VwfR1Vee41FgT3PeP7FZQpLKbu/R5PXoXW8f8CU6ymLSY+wKkGItkcbh+eZ3Dfv46TFz3vAHlKlpE";
        //15989016026422828197803173917
        String content = "{\"hitType\":\"MOBILE_MD5\",\"hitValue\":\"d8c4787992f00ca9a73324036a7e0d7a\",\"ip\":\"127.0.0.1\"}";
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
        String partner_pulbic_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDpV1me5cT1ZMnq7J0k5h5BJOAjWnlIfcoQbQwJ4UFR1zIsOovSm+x2Z3YoUKVGvGdwUGjYYvT5/XgBPCcFZcPO7vBjPU+O8jnXEoJHNJfqJwlXS1fWTkyB1BRNbra6IeNtpCY1zz02NPaJ4V+0ALkNTo/VWjn/kxnPU7dmj/dTYwIDAQAB";
        String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAOlXWZ7lxPVkyersnSTmHkEk4CNaeUh9yhBtDAnhQVHXMiw6i9Kb7HZndihQpUa8Z3BQaNhi9Pn9eAE8JwVlw87u8GM9T47yOdcSgkc0l+onCVdLV9ZOTIHUFE1utroh422kJjXPPTY09onhX7QAuQ1Oj9VaOf+TGc9Tt2aP91NjAgMBAAECgYBPR9F4boMECXGdczVVQyaGZbwN5wCMQ8jy2cocVT93ShGO+3lkXnvyIub/fZ8aMItImtl0o/KuOZObf8+WQuRK9a4Wsr65RQSfR6xCPVgxXdqndt9oNyoJZazomE4n51uvBC6BdA91ooF7EqKCPIAPOKlygu+V+zB/2zgMJzu4GQJBAP0xKSR9z/XY7qrkQhr7QgZmwDAdDqGep7E5Cc+ItO3+y0So2vRy6YKzeC3JXIelIC++HhNF8bcGji6rrpnMo50CQQDr7dSsfcXjDWFBjnoqVbl/p/131oywb4hloGijntMpnqMiIvWhSLjnqdgcz6S1ZfiKOfeb6fAY0acrvPAhw6L/AkA0F+VLKMec4aFZb9VaD9Ap2QI55ACaqDYAdKfcF1iCjyXrXoKOQQZiaeKUKRXsosDYkdlGReHRsnuWhqRJ6JzRAkAvJftPcV8fjef2uuttFG6atU6xKT46cD+Y16KxuCbI9XvycXwW/Dp/iXC36UMoQTWXIhh6nxitTRCUbBCtHrSvAkBCZohvT3+VwfR1Vee41FgT3PeP7FZQpLKbu/R5PXoXW8f8CU6ymLSY+wKkGItkcbh+eZ3Dfv46TFz3vAHlKlpE";
        //15989016026422828197803173917
        /*String content = "{\"hitType\":\"MD5\",\"hitValue\":\"3e9ab315b16e008bbebc2d00acb2b9b0\",\"ip\":\"127.0.0.1\"}";*/
        String content = "{\"flowNo\":\"P5920315500541378560\",\"mobileNo\":\"13530227101\"}";
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
        String content = "13530227101";
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
