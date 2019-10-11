package com.nostalgia.utils;

import com.sun.jersey.core.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA公私钥生成,加/解密,加/解签
 */
public class RSAUtils {


    private static String partnerPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVBBPf5Gphnv3tEqLD2i2StYba" +
            "hFpkYr+lxchl7xr3MyB3qAJpfN89S8/qfTty2ya4yL0eTZeGu0hjooDaLavR/ATM" +
            "yXbFphkQyWkcvFK7eVOL3A9100pT/VVWBfC/rhsSi8d//PNxbyl7FYWs9iCTCUY6" +
            "WOsxccJie/RdJpjB7QIDAQAB";
    private static String partnerPrivateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANUEE9/kamGe/e0S" +
            "osPaLZK1htqEWmRiv6XFyGXvGvczIHeoAml83z1Lz+p9O3LbJrjIvR5Nl4a7SGOi" +
            "gNotq9H8BMzJdsWmGRDJaRy8Urt5U4vcD3XTSlP9VVYF8L+uGxKLx3/883FvKXsV" +
            "haz2IJMJRjpY6zFxwmJ79F0mmMHtAgMBAAECgYBuzaIw8jXL9dIMAYec7N6L09UD" +
            "0ZjbYuphppHpRAj40SVwWHp4uLW+wrKyPNYxloF72R9WpfHN6ZlsClmQI/WdX53/" +
            "laL7RKa7xSFYP4jW3l5VEiQNgAminSak098C1d7xKf52F29/4+HB2/KJSq9oQXjg" +
            "1hwvQ8cz8cDt8EutAQJBAPNi23vBka3isd3MvXZRtcP5lnr44JN1Ix/UTTfdVc6D" +
            "FkX+xpozUUvGZ2MDoDI5Zmsyn/7MRgZNzIZqjT1S+mECQQDgDkf3X7zbKl4M3qQV" +
            "jzCUKk6mJwgVnuReA0PPn78VwQ4IeqOvGHFWAQEe9S0+CGeH2tfz7GKYqMd0bYiX" +
            "a+sNAkEAklP7NZqZZXwICBwSRNK3f43NhT2gd8dTSM2xZ0bxUenKOGcHLKpx1CcC" +
            "/aquY8PS6dxUCTLzXtLjhmUFabs7wQJBAKeQZqgN1JsAK4hqdcKd7RHSNjGy3Sv2" +
            "QgpBXNSJPwpQ8GLM/V9040YTyDfT2vsao/sJYxpMvkw3ZbugM1gzYH0CQDu5oFa4" +
            "mM//ir4/GzFhh1LmFLDnJPlmrxF4TzKjmw18uf2zmdE/dwchewOGhTdglbb7GnJh" +
            "bVxEciHSeXtXs0Q=";
    private static String requestData = "{\"input\":{\"partnerCode\":\"weilaijishi\",\"mobileNo\":\"13838389438\"}}";

    private static String ppsPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJs0Tcvey7ht9YZhwNtXgkw7qSDp5FA7L14Yl+j+c5ufpjBpyxA9SfJdPnVN1OGPKnxMfUYktvRMRPvRSRxy8l48+qkiA1z06LVSyrnIWADGfasJv36mMcvrE3ot5+Wb/CSDVFnCrwcWcSxAlR9J1I7HeI1T62Ym2nc/CbTU6JMzAgMBAAECgYA9GqiOXVcDc3c4wv+0240XCl4Z8TvMQqDxgOk99//4AzDg2qXx7M9SNlfCwzPO4hit+0dO+GF3aRe3tLv+EVtOFeVGuGxQkTZi04ovKEbyHy1DzYrkc4+WpaS5I31zF/f4fw+/IPnDn+TZZJ+m12uM0xKK6PI18kHOd3kNi3EJ4QJBAMra2XYwSSw6d5d2+3l939ala8mm9jIl9yvu+V49SMhU5Gssa8+vduswgQApLvRDfrwVHLpRycnskKR+R0aNpzkCQQDD3ZuBfPyXdaCh0Xv3hSe43VthXclgYYhgfubsX8HmaiXZ4oj/oTOkeKyWHXGLQlJQukZbwb7EUOR3vnmYm8HLAkEAwdaeNfGt+jVkUbfAVTeSzOkFNov0dbcRmUmhwAuPoN595mtsGejxGYwfuKeh1ococ1E5QlElIW6MSKLiOOjjAQJAMF71PYhZdSo2jmAGxn0a7zuzips31Vag8HvGmc+YOkgyqtmYTdFIyLCIptYEqYiqfYdTQuvZKfB0S+I9c2Pb+wJATkKtwG632UJFVIqA/IBXnw0l114dNC36LFPVZW5qmv4v6+lk63GgltCuuRFrX3ffqRhauZWDxxQ8fYZ/OXzpjg==";
    private static String ppspublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbNE3L3su4bfWGYcDbV4JMO6kg6eRQOy9eGJfo/nObn6YwacsQPUnyXT51TdThjyp8TH1GJLb0TET70UkccvJePPqpIgNc9Oi1Usq5yFgAxn2rCb9+pjHL6xN6Leflm/wkg1RZwq8HFnEsQJUfSdSOx3iNU+tmJtp3Pwm01OiTMwIDAQAB";

    private static String responseSign = "fBN+twL+6Hii21LPeY4RjYiRoubfhDBfg0151XP6ZXZAd3jVMkbvlbYcr3IHx/pL3bAtUl3OwHloLhNSjnZZ3V+RYc03ODbPMJOZfp3R5KsQoAHGwiFVw3vCu9859uye+MuQ4uKpqka0TSdta9wN0ulAMyz6Ut7kkPSw46ntDhA=";
    private static String responseSync = "DmScoaeXLXnbWaO83WgKoPM0ccu30Xo7d2e2c4gzz2xraTYrOk4eTSrV4pOAx995syWqnjptlKyJxyswfADOnERT8rY8mOlPtdLefWEMMU7KL3do4mTBjhnjXyxZNEF2hk/WT6XWX1BlMy/mJoIPaSoIEMTGZ9niw35Krp0BvzEyQSnz85ZK75jdCF77cw253tAyRBiatFp1QJxALChuLi0tNIiPcH2NPNe9Lww2mjZF6oGTgcVIMy0c8Ph9+jVGgzozShQ36MJpsSeizwREiWQqaoRolcq7Us42oVXCG0VtaXtzM1akeWkv0cEt+CqNlWlBaHti0CskmrhMURJ15Q==";
    private static String responseSync1 = "dUcEKRLxz5rYWIZBXAOXrMF6Dr5hCiC70Ybg/mkH0LBHIhdwi+ysrP6sGFz654/o70TDGjxqO42OsjyxisNkmdtmifJZrv38JZy2KMkpWeOyzHZwVtoLr7SAdLikRZlzZfWaNI7/XaxZGgeI3uGo7GTWgjEjs7RTeKhPuqKUTTE=";

    /**
     * 签名
     *
     * @param privateKeyString 私钥
     * @param content 加签内容
     * @return
     */
    public static String rsaSign(String privateKeyString, String content) throws
            Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", new
                BouncyCastleProvider());
        PKCS8EncodedKeySpec priPKCS8 = new
                PKCS8EncodedKeySpec(Base64.decode(privateKeyString));
        PrivateKey privateKey = keyFactory.generatePrivate(priPKCS8);
        Signature signature = Signature.getInstance("SHA256WITHRSA");
        signature.initSign(privateKey);
        signature.update(content.getBytes());
        return new String(Base64.encode(signature.sign()));
    }
    /**
     * 验签
     *
     * @param publicKeyString 公钥
     * @param content 验签内容
     * @param signedString 签名
     */
    public static boolean rsaVerifySign(String publicKeyString, String content,
                                        String signedString) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", new
                BouncyCastleProvider());
        X509EncodedKeySpec bobPubKeySpec = new
                X509EncodedKeySpec(Base64.decode(publicKeyString));
        PublicKey publicKey = keyFactory.generatePublic(bobPubKeySpec);
        Signature verifySign = Signature.getInstance("SHA256WITHRSA");
        verifySign.initVerify(publicKey);
        verifySign.update(content.getBytes());
        return verifySign.verify(Base64.decode(signedString));
    }

    public static void main(String[] args) throws Exception {

        /*String requestData = "JOEozXTQtJOKaFTT/old+IirwREu+deWU1To06yOKgtRIgyXSO69k+JtwFlv3jOsZjX21r4HFr9SgfJZY"+
            "acqozzlZCvXkXOVGoRUJmZ9ymMn2/OmTFB8xdFl/19MNagVgEtbgjykxPRihDwHnn8PirFMINywunjDWWVbpNjfZOY=";
        String signString = rsaSign(privateKey, requestData);
        System.out.println(signString);
        boolean verifySignResult = rsaVerifySign(publicKey, requestData,
                signString);
        System.out.println(verifySignResult);*/
        /*Map<String, Object> stringObjectMap = genKeyPair();
        partnerPublicKey =stringObjectMap.get("PUBLIC_KEY").toString();
        partnerPrivateKey =stringObjectMap.get("PRIVATE_KEY").toString();*/

        //加密
        String encryptString = rsaEncrypt(requestData,ppspublicKey);
        System.out.println("密文:"+encryptString);
        //签名
        String rsaSign = rsaSign(partnerPrivateKey, encryptString);
        System.out.println("签名:"+rsaSign);

        //解密
        /*System.out.println("是否相等:"+ responseSync.equals(rsaVerifySign(partnerPublicKey,responseSign,null)));
        String data = rsaDecrypt(responseSync, partnerPrivateKey);
        System.out.println(data);*/

        //加密解密
        /*String encrypt = rsaEncrypt(requestData, ppspublicKey);
        System.out.println(encrypt);
        System.out.println(rsaEncrypt(requestData, ppspublicKey));
        System.out.println(rsaDecrypt(encrypt,ppsPrivateKey));*/





    }





    /**
     * RSA加密为base 64 code
     *
     * @param content 待加密的内容
     * @param publicKey 加密公钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String rsaEncrypt(String content, String publicKey) throws
            Exception {
        return new String(Base64.encode(encryptByPublicKey(content.getBytes(),
                publicKey)));
    }
    /**
     * 公钥加密
     *
     * @param data 源数据
     * @param publicKey 公钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey)
            throws Exception {
        byte[] keyBytes = Base64.decode(publicKey);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key publicK = keyFactory.generatePublic(x509KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > 117) {
                cache = cipher.doFinal(data, offSet, 117);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * 117;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }
    /**
     * @param content 已加密数据
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static String rsaDecrypt(String content, String privateKey) throws
            Exception {
        return new String(decryptByPrivateKey(Base64.decode(content),
                privateKey));
    }
    /**
     * 私钥解密
     *
     * @param encryptedData 已加密数据
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String
            privateKey)
            throws Exception {
        byte[] keyBytes = Base64.decode(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > 128) {
                cache = cipher.doFinal(encryptedData, offSet, 128);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * 128;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

    /*public static void main(String[] args) throws Exception {
        String responseData = "{\"flag\": \"S\",\"data\": {\"url\":
            \"https://mkt.360jie.com.cn/activity/ch/bjwtyicaidsp/lanmu1\"}}";
        String encryptString = rsaEncrypt(responseData, publicKey);
        System.out.println(encryptString);
        String decryptString = rsaDecrypt(encryptString, privateKey);
        System.out.println(decryptString);
    }*/

    /**
     * <p>
     * 生成密钥对(公钥和私钥)
     * </p>
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put("PUBLIC_KEY", publicKey);
        keyMap.put("PRIVATE_KEY", privateKey);
        return keyMap;
    }
}


