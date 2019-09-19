package com.api.socket.sockettest4;

import com.api.socket.util.CloseSocketUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by wen on 2019/09/18
 * 在线聊天室：服务端
 * 目标：加入容器实现群聊和私聊
 */
public class ServerChat {
    private static Logger logger = LoggerFactory.getLogger(ServerChat.class);
    private static CopyOnWriteArrayList<ClientHandler> all = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        ServerChat serverChat = new ServerChat();
        serverChat.startThread();
    }

    //  启动服务端线程
    public void startThread() {
        try {
            System.out.println("正在启动服务器 ....");
            ServerSocket serverSocket = new ServerSocket(8083);
            System.out.println("服务器启动完毕  .....");

            System.out.println("等待客户端连接 ....");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接进来了  ....");

                ClientHandler handler = new ClientHandler(socket);
                all.add(handler);  //  管理所有成员

                new Thread(handler).start();
            }
        } catch (IOException e) {
            logger.error("异常：[{}]", e.getMessage());

        }

    }


    //  内部类，实现Runnable接口
    public static class ClientHandler implements Runnable {
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket socket;
        private boolean isRuning;
        private String name;

        //  构造方法，实例化上面的属性
        public ClientHandler(Socket socket) {
            this.socket = socket;
            isRuning = true;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                //  获取名称
                this.name = receive();
                this.send("欢迎上线 ....");
                this.sendOthers(this.name + "上线了！", true);

            } catch (IOException e) {
                logger.error("出现了异常，资源关闭了！");
                closeRelease();
            }
        }

        //  接收消息
        public String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                logger.error("异常：关闭资源");
                closeRelease();
            }
            return msg;
        }

        //  发送消息
        public void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                logger.error("异常：发送消息失败");
                closeRelease();
            }
        }

        /**
         * 群聊：获取自己的消息，发给其他人
         * 私聊：约定数据格式：@xxx:msg
         *
         * @param msg
         * @param isSys
         */
        public void sendOthers(String msg, boolean isSys) {
            boolean isPrivate = msg.startsWith("@");
            if (isPrivate) {  //  私聊
                int idx = msg.indexOf(":");
                //  获取目标和数据
                String targetName = msg.substring(1, idx);
                msg = msg.substring(idx + 1);
                for (ClientHandler handler : all) {
                    if (handler.name.equals(targetName)) {
                        handler.send(this.name + " 悄悄对你说： " + msg);
                        break;
                    }
                }
            } else {  //   群聊
                for (ClientHandler handler : all) {
                    if (this == handler) {  //  自己
                        continue;
                    }
                }
                if (!isSys) {
//                    System.out.println("非系统消息");
                    send(this.name + " 对所有人说：" + msg);
                } else {
//                    System.out.println(" 系统消息 ");
                    send(msg);  //  系统消息
                }
            }
        }

        //  关闭资源
        public void closeRelease() {
            this.isRuning = false;
            CloseSocketUtil.close(dis, dos, socket);
            // 退出
            all.remove(this);
            this.sendOthers(this.name + " 下线了!", true);
        }

        @Override
        public void run() {
            while (isRuning) {
                String msg = receive();
                if (!msg.isEmpty() && StringUtils.isBlank(msg)) {
                    this.sendOthers(msg, false);
                }
            }
        }
    }
}
