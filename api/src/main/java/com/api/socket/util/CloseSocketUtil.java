package com.api.socket.util;

import java.io.Closeable;
import java.io.IOException;

/**
 *   关闭流，释放资源工具类
 */
public class CloseSocketUtil {

    public static void close(Closeable... closeables){
        for (Closeable closeable : closeables) {
            if (closeable != null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
