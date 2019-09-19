package com.api.socket.sockettest5.notpacket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8084);
            System.out.println("已启动服务器， 等待连接");
            ExecutorService service = new ThreadPoolExecutor(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
            while (true){
                Socket socket = serverSocket.accept();
                service.submit(new Task(socket));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
