package com.api.socket.sockettest2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务器端
 */
public class Server implements Runnable {

    private Socket socket;
    private int clientNO;

    public Server(Socket socket, int clientNO) {
        this.socket = socket;
        this.clientNO = clientNO;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            byte[] bytes = new byte[1024];
            int len = in.read(bytes);

            String str = new String(bytes, 0, len);
            System.out.println("客户端说："+str);

            out.write(str.getBytes());
            out.flush();

            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("服务端已准备就绪 .....");

            //  创建线程池
            ExecutorService exec = Executors.newCachedThreadPool();
            System.out.println("线程池已准备就绪 ....");
            int num = 1;
            while (true) {
                System.out.println("等待客户端连接 .....");
                Socket socket = serverSocket.accept();
                System.out.println("第 " + num + " 个客户端连接进来了 ...");
                exec.execute(new Server(socket, 1));

                num++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
