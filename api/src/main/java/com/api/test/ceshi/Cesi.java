package com.api.test.ceshi;


import com.api.util.aes.AES;
import com.api.util.rsa.RSA;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

@Service
public class Cesi {

    @Value("${fileClass.filePath.publicKey2}")
    private String publicKey;

    @Value("${fileClass.filePath.privateKey}")
    private String privateKey;

    public void jiami() throws Exception {
        String data = "{\n" +
                "    \"order_record_id\":\"40582921\",\n" +
                "    \"order_number\":\"1565402872607\",\n" +
                "    \"order_status\":\"3\",\n" +
                "    \"cancel_status\":\"3\",\n" +
                "    \"content\":\"取消工单\",\n" +
                "    \"remark\": \"其他-总部消息通知用户取消上门\",\n" +
                "    \"ext_data\": {\n" +
                "        \"factory_cancel_order_time\":\"1559301473\",\n" +
                "    },\n" +
                "}";
        String str = RSA.createStr();
        //  密码加密
        String encrypt = RSA.encrypt(str, RSA.getPublicKey(privateKey));
        System.out.println(encrypt);
        //  数据加密
        String enctype = AES.enctype(data, str);
        System.out.println(enctype);
    }

    public void jiemi() throws Exception {
        String data = "NufBthNDXoaWZVxyaXOFprpCqH675/cTyOQjjqjer1jSZwTqVP2Mb+IuKq3SERzHZHcCMfIJu2bIdTWL7BHo5W4eweJzBP51v3SQTm8jFR88Ap9wNwG1AAaTxUf29bxgxgMKJC9TDql8o0YM9KDOwoo889DbVV6goqPrB4nGv5U=";
        String decrypt = RSA.decrypt(data, RSA.getPrivateKey(publicKey));
        System.out.println(decrypt);
    }


    @Test
    public void test1() throws Exception {
        String pub = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDiD2uNT9dlLqSap7oMrq83SVvKFjo8t5lBxz+B3P4cBnwwW9CZw3UHmtI+bsQM/RJkWvXN8AsuFatRxFiNuUv+5f8cbNABVzf/DaEt7Sc/I0xx5OXeJY8FKAgdjYYwP8dpCrk88NxWBng9tLSkr5iJ/XtAkOgi/w7Vsxrxx6El5QIDAQAB";
        String data = "{\n" +
                "    \"order_record_id\":\"40582921\",\n" +
                "    \"order_number\":\"1565402872607\",\n" +
                "    \"order_status\":\"3\",\n" +
                "    \"cancel_status\":\"3\",\n" +
                "    \"content\":\"取消工单\",\n" +
                "    \"remark\": \"其他-总部消息通知用户取消上门\",\n" +
                "    \"ext_data\": {\n" +
                "        \"factory_cancel_order_time\":\"1559301473\",\n" +
                "    },\n" +
                "}";
        PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(pub.getBytes());
        KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privKey = mykeyFactory.generatePrivate(priv_spec);
        Cipher cipher = Cipher.getInstance(mykeyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privKey);
        byte[] bytes = cipher.doFinal(data.getBytes());
        String s = Base64.encodeBase64String(bytes);
        System.out.println(s);
    }

    @Test
    public void test2() throws Exception {
        String data = "NrKbwU3wZh9svTFUr+oXExIqx8kbO/Ye3wDlNGJS/kSGLNbIu/x4ckpwsLeI2jq0lTYPb1qZZbNJaYBz0IZt6Q+lIr/T4XmuYYN6SjUoVpXqz4kfUW2zDOF0rO3tYT9rmv/76VZVInDCfeOXQPrb8wstgnRKbEK6k79RxEzgNas=";
        String pub = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD9Xe5rsBd02jaBxakM+dsEN075f4iFNIduZbwe/xo8XQ85/xUEKgAFq5btVptrtruKvwmZLFW6OGKG3625cjoku/Aon52VZp4ky5kncT62OnH+UQajCtQP96XwtX/oljDASapRW2ku5QTCgw2TzJTTPRR3RRSPqJlpKE49xzQ6JQIDAQAB";
// 对密钥解密
//        byte[] keyBytes = decryptBASE64(key);
// 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(pub.getBytes());
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
// 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] bytes = cipher.doFinal(data.getBytes("UTF-8"));
        String s = new String(bytes);
        System.out.println(s);
    }

}
