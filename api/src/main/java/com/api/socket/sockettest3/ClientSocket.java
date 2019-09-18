package com.api.socket.sockettest3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {

    public static void main(String[] args) {
        ClientSocket socket = new ClientSocket();
        socket.startThread();
    }

    private Socket socket;

    public ClientSocket() {
        try {
            System.out.println("正在连接服务器端 ....");
            socket = new Socket("localhost", 8083);
            System.out.println("连接服务器端完毕 ....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  启动客户端线程方法
    public void startThread() {
        // 启动线程，读取服务端发送过来的信息
        ServerHandler handler = new ServerHandler();
        new Thread(handler).start();

        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            PrintWriter pw = new PrintWriter(bw, true);
            // 输出
            while (true) {
                String line = sc.nextLine();
                if ("exit".equals(line)) {
                    pw.close();
                    bw.close();
                    socket.close();
                    break;
                }
                pw.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //  创建一个私有服务端内部类ServerHandler，并实现Runnable接口，该线程用来读取服务端发送过来的数据
    private class ServerHandler implements Runnable {
        @Override
        public void run() {
            BufferedReader br = null;
            try {
                 br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("服务器说：" + line);
                }
            } catch (IOException e) {
//                e.printStackTrace();
            }finally {
                try {
                    br.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
