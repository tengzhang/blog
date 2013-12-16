package com.iris.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * CommonUtil
 *
 * @author: zhangteng
 * @time: 13-12-5 下午3:17
 */
public final class CommonUtil {

    /**
     * 对一个byte数组计算md5值
     *
     * @param b
     * @return
     */
    public static String md5(byte b[]) {
        int i;
        StringBuffer buf = new StringBuffer("");
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0) i += 256;
            if (i < 16) buf.append("0");
            buf.append(Integer.toHexString(i));
        }
        return buf.toString();
    }

    /**
     * 对一个字符串计算md5值
     *
     * @param plainText
     * @return
     */
    public static String md5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
            return md5(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
