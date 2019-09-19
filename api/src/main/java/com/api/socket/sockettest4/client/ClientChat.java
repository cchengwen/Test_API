package com.api.socket.sockettest4.client;

import com.api.socket.util.CloseSocketUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChat {

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
             br = new BufferedReader(new InputStreamReader(System.in));
            Socket socket = new Socket("localhost", 8083);

            System.out.println("请输入名称：");
            String line = br.readLine();
            //  建立 连接
            //  客户端发送消息
            new Thread(new Send(socket, line)).start();
            // 接收消息
            new Thread(new Receive(socket)).start();
        } catch (IOException e) {
            CloseSocketUtil.close(br);
        }
    }
}
