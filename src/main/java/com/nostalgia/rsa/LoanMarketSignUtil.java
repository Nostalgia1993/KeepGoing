package com.nostalgia.rsa;

import com.sun.jersey.core.util.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 贷超加验签工具
 *
 * @author : liuqi
 * @date : 2019/7/20.
 **/
public class LoanMarketSignUtil {

    private static String privateKey = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBALnl2vsq7jgaswRm" +
            "d7plE/Uv3UfXoBUvq66zH+qv6QN1hw4qp2YlDfrO7LzGINMvV7sMpmbq8bEYzZyG" +
            "DhBn1xdrloUZg7rFugN5uvK6p/H7x0DM0jkOMvYsktZCQ2H4XA3jVy/jwb5vsnhN" +
            "l1GA5m2f2m4nGPXOseyXt9f+7onLAgMBAAECgYEAqhB447xjkFoEmarwL0pXFsCC" +
            "DD5cCeXBhyIBud7SKcL0Gea1nAGcJ230L8KFtw2hkdJBzPd0wpIxT9dnuGR25Tuo" +
            "0OVccD+ggJp2LypWg9MhNV4A1U62LOqo+LD5Kj3Tk4eYZFtHkCw7LR05FhWZgsTn" +
            "EFMWKihNhNO9GJoW/jECQQDi3WN/x2bovBFgvvjoNQ2wF4gB9Qq3dPDuJmnHDi0k" +
            "YkU/doSjj+kedr0DzrtwaCLY7op6+AHEbIJL7m5mnXXzAkEA0cWZ5ikd8oR3iRG6" +
            "aYszDyXnyjxHOKea8jcjeJUdgHQeRYoaEW1YQyQqKp3ty2Q5FLgbkHdnftGQiBg/" +
            "+LTayQJBANRYwwxUeZe4iU+UEWlQV2qO7Ahg89H6TJWtMO9X7psSvJyFc+uhBWQ1" +
            "YgCRXdL+Njf1N3uYbhcMNf2axI2aL08CQQC5W/gvrqltwKu3jNjBpmTJv97fjwAI" +
            "CeIaoapQRMM63GBbZjq+p3ZUbcJswfx7uuXNbxm8QCZNo3QpLfRpGbYxAkAUfTGt" +
            "NuOtl56WA4oGMrAxZ2MrfBQB9U+QixXmM+ArQ3b8e/POSnydaToTuV5U60X6V/g/" +
            "py1mstCbueRFJupD";
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC55dr7Ku44GrMEZne6ZRP1L91H" +
            "16AVL6uusx/qr+kDdYcOKqdmJQ36zuy8xiDTL1e7DKZm6vGxGM2chg4QZ9cXa5aF" +
            "GYO6xboDebryuqfx+8dAzNI5DjL2LJLWQkNh+FwN41cv48G+b7J4TZdRgOZtn9pu" +
            "Jxj1zrHsl7fX/u6JywIDAQAB";
    private static String requestData = "ZVa/q09FqWRaCY3dKgp/BmJQfLYRVD10j4lpulKuRgEtGqWN1ljrqehbTDjQcD7t063OX6eOhy86" +
            "pYTax51BMjkWBlrJP06eQZFKK/KhaBa1RC485OcuELQ5KA8Q7c6l5FYMwKh5z1rR8cixZEJ+qwr0" +
            "wwi5e5kPJu5fMwuJmGKMnn8aMV2K0iTf+c0guOqHADY87/OmOQwDS8zNdgVSmCYGIdXKO4rwSM4U" +
            "AIKQikOC9cieZd6Bim1PA0dukHeZvHzivSiDs/RYciPG9hjlNujozaE1762EKeSKa5D+wNsOOhTV" +
            "VJJbs3+PfHJOWRRKDDuCOn1vJ7vuN0MDVYEelw==";

    /**
     * 签名
     *
     * @param privateKeyString 私钥
     * @param content          加签内容
     * @return
     */
    public static String rsaSign(String privateKeyString, String content) throws
            Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", new BouncyCastleProvider());
        PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKeyString));
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
     * @param content         验签内容
     * @param signedString    签名
     */
    public static boolean rsaVerifySign(String publicKeyString, String content, String signedString) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA", new BouncyCastleProvider());
        X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(Base64.decode(publicKeyString));
        PublicKey publicKey = keyFactory.generatePublic(bobPubKeySpec);
        Signature verifySign = Signature.getInstance("SHA256WITHRSA");
        verifySign.initVerify(publicKey);
        verifySign.update(content.getBytes());
        return verifySign.verify(Base64.decode(signedString));
    }

    public static void main(String[] args) throws Exception {
        String signString = rsaSign(privateKey, requestData);
        System.out.println(signString);
        boolean verifySignResult = rsaVerifySign(publicKey, requestData, signString);
        System.out.println(verifySignResult);
    }
}
