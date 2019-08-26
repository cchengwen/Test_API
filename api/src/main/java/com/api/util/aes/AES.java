package com.api.util.aes;


import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AES {
    private static final String KEY_ALGORITHM = "AES";  //   加密方式
    private static final String CHAR_SET = "UTF-8";   //  字符集
    private static final Integer SECRET_KEY_LENGTH = 128;  //  加密长度
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding"; //  加密模式


    /**
     * AES  加密
     *
     * @param data        加密的数据
     * @param passwordKey 公钥加密
     * @return
     */
    public static String enctype(String data, String passwordKey) throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        if (StringUtils.isAnyEmpty(data, passwordKey)) {
            return null;
        }
        byte[] raw = passwordKey.getBytes(CHAR_SET);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(DEFAULT_CIPHER_ALGORITHM); //  算法/模式/补码方式
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(data.getBytes(CHAR_SET));
        //     此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return new Base64().encodeToString(encrypted);
    }


    /**
     * AES  解密
     *
     * @param data        要解密的密文
     * @param passwordKey 解密的密钥
     * @return
     */
    public static String decrypt(String data, String passwordKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        if (StringUtils.isAnyBlank(data, passwordKey)) {
            return null;
        }
        byte[] raw = passwordKey.getBytes(CHAR_SET);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        //先用base64解密
        byte[] original = cipher.doFinal(new Base64().decode(data));
        return new String(original, CHAR_SET);
    }


    /**
     * 密钥生成器
     *
     * @return
     */
    public static String createKey() throws NoSuchAlgorithmException {
        //  密钥生成器，指定为AES算法， 不区分大小写
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        // 初始化生成器，生成一个128位的随机源，
        keyGenerator.init(SECRET_KEY_LENGTH);
        //  生成原始对称密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //   获得原始对称密钥的字节数组
        byte[] keyEncoded = secretKey.getEncoded();

        return Base64.encodeBase64String(keyEncoded);
    }


    private static SecretKeySpec getSecretKey(final String passwordKey) throws NoSuchAlgorithmException {
        //   生成指定算法的密钥的生成器
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        //  初始化生成器
        keyGenerator.init(SECRET_KEY_LENGTH, new SecureRandom(passwordKey.getBytes()));
        //   生成密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //   转换成AES的密钥
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    }

}
