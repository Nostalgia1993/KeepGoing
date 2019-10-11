package com.nostalgia.AES;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author liunian
 * @createTime 2019/9/19
 * @description
 */
public class AESUtils {


    public static String aesEncrypt(String content, String encryptKey) throws
            Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }
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
     * AES加密
     *
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的byte[]
     * @throws Exception
     */
    private static byte[] aesEncryptToBytes(String content, String encryptKey)
            throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new
                SecretKeySpec(base64Decode(encryptKey), "AES"));return cipher.doFinal(content.getBytes("utf-8"));
    }
    /**
     * base 64 decode
     *
     * @param base64Code 待解码的base 64 code
     * @return 解码后的byte[]
     * @throws Exception
     */
    private static byte[] base64Decode(String base64Code) throws Exception {
        return StringUtils.isEmpty(base64Code) ? null : new
                BASE64Decoder().decodeBuffer(base64Code);
    }
    /**
     * 转为64编码
     */
    public static String base64Encode(String msg) throws Exception {
        return StringUtils.isEmpty(msg) ? null : base64Encode(msg.getBytes("utf-8"));
    }
    public static void main(String[] args) throws Exception {
        String c = "2mJ9HiEphbBS9baw"; // 明文的密钥
        String d = base64Encode(c); // base64后的密钥
        String a = aesEncrypt("{\"type\":\"SPEEDLOAN\",\"idNo\":\"1234567890123456789\"}", d);
        // 使用base64后的密钥进行加密
        System.out.println("密文：" + a);
    }

}
