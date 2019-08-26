package com.api.util.rsa;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 私钥（分段）加密，公钥（分段）加密
 */
public class RSA2 {

    /**
     * 公钥加密
     *
     * @param data      数据
     * @param publicKey 公钥
     * @return
     */
//    public static byte[] encrypt(byte[] data, String publicKey) {
    public static String encrypt(byte[] data, String publicKey) {
        byte[] bytes = Base64.decodeBase64(publicKey.getBytes());
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicK = keyFactory.generatePublic(x509EncodedKeySpec);

            //  对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicK);
            int dataLen = data.length;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            //  对数据分段加密
            while (dataLen - offset > 0) {
                if (dataLen - offset > 117) {
                    cache = cipher.doFinal(data, offset, 117);
                } else {
                    cache = cipher.doFinal(data, offset, dataLen - offset);
                }
                outputStream.write(cache, 0, cache.length);
                i++;
                offset = i * 117;
            }
            byte[] array = outputStream.toByteArray();
            outputStream.close();
//            return array;
            return Base64.encodeBase64String(array);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *   私钥分段解密
     * @param data
     * @param privateKey
     * @return
     */
    public static String decrypt(byte[] data, String privateKey) {
        byte[] bytes = Base64.decodeBase64(privateKey.getBytes());
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(bytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateK = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateK);
            int dataLen = data.length;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            //  数据分段解密
            while (dataLen - offset > 0) {
                if (dataLen - offset > 128) {
                    cache = cipher.doFinal(data, offset, 128);
                } else {
                    cache = cipher.doFinal(data, offset, dataLen - offset);
                }
                outputStream.write(cache, 0, cache.length);
                i++;
                offset = i * 128;
            }
            byte[] byteArray = outputStream.toByteArray();
            outputStream.close();
            return new String(byteArray, "UTF-8");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDiD2uNT9dlLqSap7oMrq83SVvKFjo8t5lBxz+B3P4cBnwwW9CZw3UHmtI+bsQM/RJkWvXN8AsuFatRxFiNuUv+5f8cbNABVzf/DaEt7Sc/I0xx5OXeJY8FKAgdjYYwP8dpCrk88NxWBng9tLSkr5iJ/XtAkOgi/w7Vsxrxx6El5QIDAQAB";
        String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOIPa41P12UupJqnugyurzdJW8oWOjy3mUHHP4Hc/hwGfDBb0JnDdQea0j5uxAz9EmRa9c3wCy4Vq1HEWI25S/7l/xxs0AFXN/8NoS3tJz8jTHHk5d4ljwUoCB2NhjA/x2kKuTzw3FYGeD20tKSvmIn9e0CQ6CL/DtWzGvHHoSXlAgMBAAECgYEAvDzy5hzR02NflZiNB/p91J+1WzXfEKghafCsJUsMHfIYf3w025UyYj69S1eY0Of65K4JeI6mAJ3ypofE5V6is/HFu5X2HuZ67Dwm4QOJFORft3FVfc2AaYPQr7ZmhkD6WDTsoyIFIEd3H0wcvOmED39K/3cANzlg3zaLH8bDfgECQQD007UQFjHszPTEIroLLsuHta0CJIMxII4EcLYrZKuBUGhtRWoeHcTR8FAbMFcuC4AQ0nUujCgjWtVDmGYvD9WhAkEA7GB2aZvbx0rYyp1VRFdlfYHPcfDGx1SrUjqZK0XOMH36JRN847S+JIclVTvUoqCuHT820ZOC8o625sOlbOghxQJBAIW3Q0L//FCLOHwPQ3FsI3mBfnaXHpgsYaSHMtfMaed81SwpJ2Y/eAn5qKbQ5iyd11pYt+uuXRXCPIxopha6HUECQGUIZhSF1c69IySXUxa+9FZM4colzBDvE7s16LoiQBth/UVTqxH48zzRtxdTV3ObklBV8KxrjJD4hxzjixWdsrECQDz0O619OiE7ecP2ENcSG1bmdzGmnC1atMBnEUhmEloxYrRVMdCN8dJRiWJ7Bp+kp749Wtu9gMp0VT1YfMuURCg=";
        String data = "私钥加密，公钥解密 .....";

        String encrypt = encrypt(data.getBytes(), publicKey);
        System.out.println(encrypt);

        byte[] bytes = Base64.decodeBase64(encrypt);
        String decrypt = decrypt(bytes, privateKey);
        System.out.println(decrypt);

    }
}
