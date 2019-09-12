package com.api.socket.sockettest1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket= new ServerSocket(8088);
            System.out.println("服务器端创建完成....");
            while (true){
                System.out.println("等待客户端连接....");
                Socket socket = serverSocket.accept();
                System.out.println("有客户端连接进来了 ....");
                invoke(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void invoke(Socket socket){
        new Thread(new Runnable() {  //  开启一个新线程
            @Override
            public void run() {
                //  创建对象输入输出流
                ObjectInputStream in = null;
                ObjectOutputStream out = null;
                try {
                    in = new ObjectInputStream(socket.getInputStream());
                    out = new ObjectOutputStream(socket.getOutputStream());

                    //  读取一个对象
                    Object obj = in.readObject();
                    System.out.println("客户端发送过来的数据："+obj);
                    //  将对象转换为对应类型的
                    User user = (User) obj;
                    System.out.println("转换的数据user："+user);

                    //  修改当前对象发送到客户端
                    user.setName(user.getName()+"new_name_obj");
                    user.setPwd(user.getPwd()+"new_pwd_obj");

                    //  输出到客户端
                    out.writeObject(user);
                    out.flush();  //  刷新缓冲区

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        //   关闭对象输入/输出流
                        in.close();
                        out.close();
                        //  关闭客户端
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
