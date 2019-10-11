package com.nostalgia.AES;


import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;


/**
 * AES加密工具类
 * Created by huangwujun on 2017/11/29.
 */
public class AESUtil {

    /**
     * base 64 encode
     *
     * @param bytes 待编码的byte[]
     * @return 编码后的base 64 code
     */
    private static String base64Encode(byte[] bytes) {
        return new BASE64Encoder().encode(bytes);
    }

    /**
     * base 64 decode
     *
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    private static byte[] base64Decode(String base64Code) throws Exception {
        return StringUtils.isEmpty(base64Code) ? null : new BASE64Decoder().decodeBuffer(base64Code);
    }

    /**
     * 获取byte[]的md5值
     *
     * @param bytes byte[]
     * @return md5
     * @throws Exception
     */
    private static byte[] md5(byte[] bytes) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(bytes);

        return md.digest();
    }

    /**
     * 获取字符串md5值
     *
     * @param msg
     * @return md5
     * @throws Exception
     */
    private static byte[] md5(String msg) throws Exception {
        return StringUtils.isEmpty(msg) ? null : md5(msg.getBytes());
    }


    /**
     * 转为64编码
     */
    public static String base64Encode(String msg) throws Exception {
        return StringUtils.isEmpty(msg) ? null : base64Encode(msg.getBytes("utf-8"));
    }

    /**
     * AES加密
     *
     * @param content    待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(base64Decode(encryptKey), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }

    /**
     * AES加密为base 64 code
     *
     * @param content    待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES解密
     *
     * @param encryptBytes 待解密的byte[]
     * @param decryptKey   解密密钥
     * @return 解密后的String
     * @throws Exception
     */
    private static String aesDecryptByBytes(byte[] encryptBytes, byte[] decryptKey) throws Exception {

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey, "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);

        return new String(decryptBytes);
    }

    /**
     * 将base 64 code AES解密
     *
     * @param encryptStr 待解密的base 64 code
     * @param decryptKey 解密密钥
     * @return 解密后的string
     * @throws Exception
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) {
        try {
            return StringUtils.isEmpty(encryptStr) ? null : aesDecryptByBytes(
                    base64Decode(encryptStr), base64Decode(decryptKey));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        String c = "AGU0JdU8NeUjGDSw";
        //String c = "CIopcPwQV26JKYOo+ZQ+Ug==";
        String d = base64Encode(c);
        System.out.println("密钥:" + c);
//        String d = "dGVzdHRlc3R0ZXN0dGVzdA==";
//        System.out.println("base64后的密钥:" + d);
        String a = aesEncrypt("{\"hitType\":\"MOBILE\",\"custName\":\"\",\"mobileNo\":\"13933588207\",\"ip\":\"127.0.0.1\"}", d);
        System.out.println("密文：" + a);
        System.out.println(aesDecrypt(a, d));

        String res = "{\"flowNo\":\"P4637239125199953920\",\"mobileNo\":\"13933588203\"}";
        System.out.println("密文："+ aesEncrypt(res,d));

//        String ss = "xt8TabJqq0jxUAd0R5vsn33sJWm2CpdvN9rWF1A0dO+OVXlTBtoTz61ycR5QnxJytDzid9kqeQbbTqizK4X5cR22i+ntBla9TIutk3vngCsrHuWhRioy4bPJ24LzMjdu";
//        System.out.println("解密："+aesDecrypt(ss, d));
    }

}