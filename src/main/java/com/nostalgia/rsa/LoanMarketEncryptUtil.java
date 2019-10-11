package com.nostalgia.rsa;

import com.sun.jersey.core.util.Base64;
import org.bouncycastle.util.encoders.Base64Encoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * 贷超加解密工具
 *
 * @author : liuqi
 * @date : 2019/7/20.
 **/
public class LoanMarketEncryptUtil {

    /*private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJydZiwarzJF0t+9uwb+C1TfTvP9OmkzLocMRnfQ9oB1R+ikJDbPeB5DfwwjvyS4zjKruMxCacIEdQAo8XExKxHq508IDrWFiogVDfIZ0fycQY2Aoq2pMqsCKyYMMwWd5HARDcE3C2eDe/geh2d+AJpZEB82i1ywkPmu2KIrBhyBAgMBAAECgYEAluapzZEggYX5ew9qp4AcFvjbMAgsQbTI/eJ7+3JiML/QO338Trt0d2R9g4rl31IZi4UeF+Fd2U1GFpNcn73KSoVGh06i6UhRBhwq8zZQxM76DA8UTs0MlWIcFJ8bSu7RtYvCibl67g5ioiv7R4+rRxriEwFySdqdiGQhCsy6OskCQQDOvKqd6rPyf/XZUnYlSE5THNC/jmrkkIPbneWit8e6z3SRuI/rTtSq9Zc7MTWu0gfRvF451o6iIYWNgWaNMmQzAkEAwe8wy49JNqGHIN2ZDvqM58K4pZtqsgkkNm4GJElT2gfWaaSdSe8W7EYP4GdciR+sqzWRR8ySpu/PdEYOUzgoewJAAjyOR/kTC0uRGFHJD2wx1LpaE8hxpZleo9CYfGMqmP3HkBAEFpKawGK5yR0mLIb/KKi2CEAm+OAN9tLwjhR+ewJAMp0KTxYGNYvSiHFNEOuy+omHRzFYlz5rhQkR8UZx6+U/wDKGGlWb1e4zFo3jSKZLmiNQ1zw8yfSsX9wowO9XIQJAakP4zYSoM4ITluo3QiDZoIRHQG/pAA+OpKX68u6jINNOGTz9UI6Ur+epXjD18a2Iw690QyOMKQgFQHwMmwg7EA==";
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC55dr7Ku44GrMEZne6ZRP1L91H" +
            "16AVL6uusx/qr+kDdYcOKqdmJQ36zuy8xiDTL1e7DKZm6vGxGM2chg4QZ9cXa5aF" +
            "GYO6xboDebryuqfx+8dAzNI5DjL2LJLWQkNh+FwN41cv48G+b7J4TZdRgOZtn9pu" +
            "Jxj1zrHsl7fX/u6JywIDAQAB";
    {"responseData":"Odu5ie+M45Z/SaADI1j8UCnDUamkJlW2W7fFeJ9+nPdHbdb5wuGmRXWbTf9i+JFKmuZYgf6Y7N01bxQJpneI72Y9PG1VjLTnaZlte5O3eJi03z/kllxf4V0rLJcaPFVvihm7HPbWWw43TJDZg0Tg0cDEJ6Ur3F5s8ZfCornPLDA=","sign":"XQ/GUpNKOR5LQeek1ywL2ctUJKvoKaIVBJX9OCUcYOCMRoOcPAsQUTsAjxaJA1lLDJniMHVQ7zjpo1C/U2IweBD3TBrsn55KN20kb9/tDm40pREnPVHZypJjgEAdudeVo/s7sYS4Gm2PFEyLlj3Dmh1OucSz+zZTh9B71MPjUmw="}
    private static String responseData = "ay04nArG6jW2Pwzp50EyUX7r8btJGKhn0Wf+mZX7g1HRZJn48VfL9I/AQScOR6Xjkf6u2Sr1R960R61yM9jz0Onqh/w2/DQBneyZwg03eTtgZ6eUnikH6VPQoYnomul9+xwHUflXSXc0qfpLs6Fwmscuilk7yfkCs9qIyzxNXDQ=";*/

    /**
     * 加密算法RSA
     */
    public static final String KEY_ALGORITHM = "RSA";
    /**
     * 获取公钥的key
     */
    public static final String PUBLIC_KEY = "RSAPublicKey";

    /**
     * 获取私钥的key
     */
    public static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * RSA加密为base 64 code
     *
     * @param content   待加密的内容
     * @param publicKey 加密公钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String rsaEncrypt(String content, String publicKey) throws Exception {
        return new String(Base64.encode(encryptByPublicKey(content.getBytes(), publicKey)));
    }

    /**
     * 公钥加密
     *
     * @param data      源数据
     * @param publicKey 公钥
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {
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
     * @param content    已加密数据
     * @param privateKey 私钥
     * @return
     * @throws Exception
     */
    public static String rsaDecrypt(String content, String privateKey) throws Exception {
        return new String(decryptByPrivateKey(Base64.decode(content), privateKey));
    }


    /**
     * 私钥解密
     *
     * @param encryptedData 已加密数据
     * @param privateKey    私钥
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, String privateKey) throws Exception {
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

    /**
     * <p>
     * 生成密钥对(公钥和私钥)
     * </p>
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> genKeyPair() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }


    /**
     * <p>
     * 生成密钥对字符串(公钥和私钥)
     * </p>
     *
     * @return
     * @throws Exception
     */
    public static Map<String, String> genKeyPairStringMap() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        String publicKeyString = new BASE64Encoder().encodeBuffer(publicKey.getEncoded()).replaceAll("\r\n|\r|\n","");
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        String privateKeyString = new BASE64Encoder().encodeBuffer(privateKey.getEncoded()).replaceAll("\r\n|\r|\n", "");
        Map<String, String> keyMap = new HashMap(2);
        keyMap.put(PUBLIC_KEY, publicKeyString);
        keyMap.put(PRIVATE_KEY, privateKeyString);
        return keyMap;
    }





    public static void main(String[] args) throws Exception {
        Map<String, Object> keyPairMap = genKeyPair();
        String responseData = "ay04nArG6jW2Pwzp50EyUX7r8btJGKhn0Wf+mZX7g1HRZJn48VfL9I/AQScOR6Xjkf6u2Sr1R960R61yM9jz0Onqh/w2/DQBneyZwg03eTtgZ6eUnikH6VPQoYnomul9+xwHUflXSXc0qfpLs6Fwmscuilk7yfkCs9qIyzxNXDQ=";
        String decryptString = rsaDecrypt(responseData, keyPairMap.get(PUBLIC_KEY).toString());
        System.out.println("responseData:"+responseData);
        System.out.println(decryptString);
    }
}
