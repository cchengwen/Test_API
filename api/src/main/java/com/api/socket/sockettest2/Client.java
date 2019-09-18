package com.api.socket.sockettest2;

import java.io.*;
import java.net.Socket;

/**
 *   客户端
 */
public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        BufferedWriter bw = null;
        try {
            socket = new Socket("localhost", 8080);

            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            bw.write("服务器+66");
            bw.flush();

            InputStream in = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = in.read(bytes);
            String str =  new String(bytes, 0, len);
            System.out.println("服务器返回："+str);

            in.close();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
