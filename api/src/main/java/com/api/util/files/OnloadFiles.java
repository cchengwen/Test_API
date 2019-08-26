package com.api.util.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class OnloadFiles {

    @Value("${fileClass.filePath.publicKey1}")
    private String publicKey1;

    @Value("${fileClass.filePath.publicKey2}")
    private String publicKey2;

    @Value("${fileClass.filePath.privateKey}")
    private String privateKey;


    // 读取神州公钥
    public String getpublickey1() {
        return getKeys(publicKey1);
    }


    // 读取公钥
    public String getpublickey2() {
        return getKeys(publicKey2);
    }


    // 读取私钥
    public String getPrivateKey() {
        return getKeys(privateKey);
    }


    //   读取.txt 文本的key
    private static String getKeys(String path) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(new File(path));
            byte[] bytes = new byte[1024 * 8];
            int len;
            StringBuilder builder = new StringBuilder();

            while ((len = in.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, len, "UTF-8"));
            }
            return builder.toString();

        } catch (FileNotFoundException e) {
            return e.getMessage();
        } catch (UnsupportedEncodingException e) {
            return e.getMessage();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
