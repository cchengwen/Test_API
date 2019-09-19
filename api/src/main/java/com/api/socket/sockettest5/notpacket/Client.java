package com.api.socket.sockettest5.notpacket;

import com.api.socket.util.CloseSocketUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8084);
            System.out.println("已连接服务器 ...");
            System.out.println("请输入昵称！");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            out.write(line.getBytes());
            //  发送请求
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        byte[] by = new byte[1024];
                        int len = 0;
                        while (true) {
                            try {
                                len = in.read(by);
                                if (len == -1) break;
                                String s = new String(by, 0, len);
                                System.out.println(s);
                            } catch (IOException e) {
                                CloseSocketUtil.close(in, out, scanner, socket);
                            }
                        }
                    }
                }
            }).start();

            //  输出接收的消息
            new Thread(() -> {
                String s1;
                System.out.println("请选择功能 ...");
                System.out.println("1 查看在线人名单");
                System.out.println("2 私聊（2 人名  信息）");
                System.out.println("3 群发（3 群发信息 ）");
                System.out.println("4 退出");
                while (true) {
                    try {
                        s1 = scanner.next();
                        out.write(s1.getBytes());
                        switch (s1){
                            case "2":
                                s1 = scanner.next();
                                out.write(s1.getBytes());
                                s1 = scanner.next();
                                out.write(s1.getBytes());
                                break;
                            case "3":
                                s1 = scanner.next();
                                out.write(s1.getBytes());
                                break;
                            case "4":
                                System.exit(0);
                        }
                    } catch (IOException e) {
                        CloseSocketUtil.close(out, in, scanner, socket);
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
