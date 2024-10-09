package com.jebysun.globlehotkey;


import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.stream.Collectors;

/**
 * AES128加解密工具类
 *
 * @author baojiong20176
 */
public class EncryptAlgorithmUtils {

    public static final String SECRET_KEY = "k.www.10jqka.com";

    public static final String IV = "offset.10jqkacom";


    /**
     * AES 加密
     *
     * @param text
     * @param secretKey
     * @param iv
     * @return
     * @throws Exception
     */
    public static String encrypt(String text, String secretKey, String iv) {
        try {
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            SecretKeySpec sks = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, sks, ips);
            byte[] encrypted = cipher.doFinal(padString(text).getBytes("UTF8"));
            return HsBase64EncodeUtils.encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 解密
     *
     * @param code
     * @param secretKey
     * @param iv
     * @return
     * @throws Exception
     */
    public static String decrypt(String code, String secretKey, String iv) {
        try {
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
            SecretKeySpec keyspec = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] decrypted = cipher.doFinal(HsBase64EncodeUtils.decode(code));
            String result = new String(decrypted, "UTF8");
            return result.trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 补位
     *
     * @param source
     * @return
     */
    private static String padString(String source) {
        char paddingChar = 0x00;
        int size = 16;
        int x = source.length() % size;
        int padLength = size - x;

        for (int i = 0; i < padLength; i++) {
            source += paddingChar;
        }

        return source;
    }

    public static void main(String[] args) {
        String time = String.valueOf(System.currentTimeMillis());
        String s = encrypt(time,SECRET_KEY,IV);
        System.out.println(s);
        String r = decrypt(s,SECRET_KEY,IV);
        System.out.println(r);
        String cc = "1699855122621";
        System.out.println(Long.valueOf(time)-Long.valueOf(cc));

        System.out.println(validLicense());;
    }

    public static boolean validLicense() {

        Long expireTime = 1000L * 60L * 60L * 24L * 90L;
        //Long expireTime = 1000L * 60L * 25 * 1 * 1;

        try {
            InputStream in = new BufferedInputStream(new FileInputStream("./license/license"));
            final String readStr = new BufferedReader(new InputStreamReader(in)).lines().collect(Collectors.joining(System.lineSeparator()));
            String time =  decrypt(readStr,SECRET_KEY,IV);
            Long diff = System.currentTimeMillis()-Long.valueOf(time);
            System.out.println(diff);//849199761
            System.out.println(expireTime);
            if (diff<expireTime) {
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}