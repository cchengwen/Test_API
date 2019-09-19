package com.api.socket.sockettest5.packet;

import com.api.socket.util.CloseSocketUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client extends AbstractCS {

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }

    @Override
    public void handle(Socket socket, OutputStream out, int cmd, String str) {
        switch (cmd){
            case 5:
                System.out.println(str);
                break;
            case 6:
                System.out.println(str);
                break;
            case 7:
                System.out.println(str);
                break;
            case 8:
                System.out.println(str);
                break;
        }
    }

    public void start(){
        try {
            System.out.println("启动客户端 ....");
            Socket socket = new Socket("localhost", 8084);

            //  第一个线程负责获取控制台输入
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Scanner sc = new Scanner(System.in);
                    try {
                        OutputStream out = socket.getOutputStream();
                        System.out.println("请输入昵称：");
                        String line = sc.nextLine();
                        send(socket.getOutputStream(), 1, line);
                        input(sc, out);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            //  第二个线程负责接收服务端的输入
            new Thread(()->{
                InputStream in = null;
                OutputStream out = null;
                try{
                    in = socket.getInputStream();
                    out = socket.getOutputStream();
                    receive(socket,in, out);
                }catch (Exception e){
                    CloseSocketUtil.close(in, out);
                }
            }).start();
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    protected void input(Scanner sc, OutputStream out) {
        try {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                logger.info("line -> [{}]", line);
                char cmd = line.charAt(0);
                // 发送消息
                // 2 获取用户
                // 3 内容 群聊
                // 4 内容 对方名字 私聊
                // 对命令进行分析
                switch (cmd) {
                    case '2':
                        logger.info("指令2：【】");
                        send(out, 2, "");
                        break;
                    case '3':
                        String content = line.substring(2);
                        logger.info("指令3：[{}]", content);
                        send(out, 3, content);
                        break;
                    case '4':
                        String content2 = line.substring(2);
                        logger.info("指令4：[{}]", content2);
                        send(out, 4, content2);
                        break;
                    default:
                        logger.info("不支持的命令！");
                }
            }
        } catch (Exception e) {
            CloseSocketUtil.close(sc, out);
        }
    }
}
