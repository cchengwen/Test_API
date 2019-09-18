package com.api.socket.sockettest3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        server.startThread();
    }

    private ServerSocket serverSocket;
    private PrintWriter[] pws = new PrintWriter[0];

    public Server() {
        try {
            System.out.println("正在启动服务器 ......");
            serverSocket = new ServerSocket(8083);
            System.out.println("服务器启动完毕 .....");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 启动线程的方法
    public void startThread() {
        try {
            System.out.println("等待客户端连接 ....");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接进来了 ....");
            ClientHandler handler = new ClientHandler(socket);
            Thread thread = new Thread(handler);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  创建一个私有的内部类ClientHandler，并实现Runnable接口
    private class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            PrintWriter pw = null;
            try {
                //  输入输出流
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                /*
                 * 通过socket获取输出流，用于给客户端发消息
                 */
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
                pw = new PrintWriter(bw, true);
                synchronized (pws) {
                    // 扩容数组
                    pws = Arrays.copyOf(pws, pws.length + 1);
                    pws[pws.length - 1] = pw;  //  将输出流放在数组最后位置
                }

                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println("客户端说：" + line);

                    synchronized (pws) {
                        //  转发给客户端
                        for (int i = 0; i < pws.length; i++) {
                            pws[i].println("客户端说：" + line);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                synchronized (pws) {
                    for (int i = 0; i < pws.length; i++) {
                        if (pws[i] == pw) {
                            pws[i] = pws[pws.length - 1];
                            //  当有客户端结束时，数组长度减1
                            pws = Arrays.copyOf(pws, pws.length - 1);
                            break;
                        }
                    }
                }
                //  关闭socket
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
