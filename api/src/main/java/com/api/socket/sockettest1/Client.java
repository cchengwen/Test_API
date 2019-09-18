package com.api.socket.sockettest1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        try {
            while (true) {
                //  连接服务器
                socket = new Socket("localhost", 8080);

                //  接收输出流中的数据
                out = new ObjectOutputStream(socket.getOutputStream());
                User user = new User("张三", "paasword");
                //  输出到服务端
                out.writeObject(user);
                out.flush();

                //  接收服务端数据
                in = new ObjectInputStream(socket.getInputStream());
                Object obj = in.readObject();

                //   转换为对象
                if (obj != null) {
                    User user1 = (User) obj;
                    System.out.println("服务端传回的数据：" + user1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                //  关闭对象输入/输出流
                in.close();
                out.close();
                //  关闭客户端
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
