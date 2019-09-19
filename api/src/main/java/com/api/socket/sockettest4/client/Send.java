package com.api.socket.sockettest4.client;

import com.api.socket.util.CloseSocketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by wen on 2019/09/18
 * 使用多线程封装了客户发送端：
 * 1.发送消息
 * 2.从控制台获取消息
 * 3.释放资源
 * 4.重写run
 */
public class Send implements Runnable {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private BufferedReader reader;
    private DataOutputStream outputStream;
    private Socket socket;
    private boolean isRunning;
    private String name;

    public Send(Socket socket, String name) {
        this.socket = socket;
        this.name = name;
        isRunning = true;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));

            //  获取控制台输入
            //  输出
            outputStream = new DataOutputStream(socket.getOutputStream());
            //  发送名称
            this.send(name);

        } catch (IOException e) {
            logger.error("异常： [{}]", e.getMessage());
            this.closeSend();
        }
    }

    //  发送消息
    public void send(String msg) {
        try {
            outputStream.writeUTF(msg);
            outputStream.flush();
        } catch (IOException e) {
            logger.error("异常：发送消息失败！");
            closeSend();
        }
    }

    //  从控制台获取消息
    public String getMsgFromConsole() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            logger.error("异常： 从控制台获取消息失败!");
            closeSend();
        }
        return null;
    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = this.getMsgFromConsole();
            if (msg != null) {
                this.send(msg);
            }
        }
    }


    //  关闭资源
    public void closeSend() {
        isRunning = false;
        CloseSocketUtil.close(outputStream, socket);
    }
}
