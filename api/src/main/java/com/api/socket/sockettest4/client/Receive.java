package com.api.socket.sockettest4.client;

import com.api.socket.util.CloseSocketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by wen on 2019/09/18
 *  使用多线程封装了客户接收端
 *  1.接收消息
 *  2.释放资源
 *  3.重写run
 */
public class Receive implements Runnable{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private DataInputStream dis;
    private Socket socket;
    private boolean isRunning;

    public Receive(Socket socket){
        this.socket = socket;
        isRunning = true;
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            logger.error("构造方法中流异常："+e.getMessage());
            closeReceive();
        }
    }

    //  接收消息
    public String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            logger.error("客户端异常：接收消息失败!");
            closeReceive();
        }
        return msg;
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = this.receive();
            if (!"".equals(msg)){
                System.out.println("客户端接收到的消息："+msg);
            }
        }
    }

    // 关闭资源
    public void closeReceive(){
        this.isRunning = false;
        CloseSocketUtil.close(dis, socket);
    }
}
