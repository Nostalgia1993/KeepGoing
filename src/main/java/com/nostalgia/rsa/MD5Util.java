package com.nostalgia.rsa;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by chengzhixiao on 2016/4/20.
 */
public class MD5Util {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(HEX_DIGITS[(b[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 0x0f]);
        }
        return sb.toString();
    }

    public static String bit32(String sourceString) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(sourceString.getBytes());
            byte[] messageDigest = digest.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            return null;
        }
    }

    public static String encoderByMd5(String str) {
        try {
            //确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
            return newstr;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 向getMD5String方法传入一个你需要转换的原始字符串,将返回字符串的MD5码
     *
     * @param str 原始字符串
     * @return 返回字符串的MD5码
     */
    public static String getMD5String(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes();
            byte[] results = digest.digest(bytes);
            StringBuilder sb = new StringBuilder();
            for (byte result : results) {
                // 将byte数组转化为16进制字符存入StringBuilder中
                sb.append(String.format("%02x", result));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }

    }

    public static void main(String[] args) {

        System.out.println(getMD5String("15511119999421127196910277570"));
    }
}
