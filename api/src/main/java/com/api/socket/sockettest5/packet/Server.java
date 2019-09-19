package com.api.socket.sockettest5.packet;

import com.api.socket.util.CloseSocketUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server extends AbstractCS {
    private Map<Socket, String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Server server = new Server();
        server.startServer();
    }

    public void startServer(){
        System.out.println("【聊天室】");
        ExecutorService service = Executors.newFixedThreadPool(10);
        try(ServerSocket serverSocket = new ServerSocket(8084)){
            while (true){
                // 来一个连接，开一个空闲线程处理请求，但上限是10
                Socket socket = serverSocket.accept();
                service.submit(()->{
                    InputStream in = null;
                    OutputStream out = null;
                    try {
                        in = socket.getInputStream();
                        out = socket.getOutputStream();
                        this.receive(socket,in, out);
                    } catch (IOException e) {
                        map.remove(socket);
                        CloseSocketUtil.close(in, out);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(Socket socket, OutputStream out, int cmd, String str) {
        try {
            switch (cmd) {
                case 1:
                    map.put(socket, str);
                    send(out, 5, "欢迎【" + str + "】来到聊天室");
                    break;
                case 2:
                    send(out, 6, map.values().toString());
                    break;
                case 3:
                    String nick = map.get(socket);
                    String c = nick +":"+str;
                    map.forEach((s, value) ->{
                        try {
                            send(s.getOutputStream(), 7, c);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    break;
                case 4:
                    String[] array = str.split(" ");
                    String n = array[0];  //  对方的名称
                    String content = array[1];  //  内容
                    boolean found = false;
                    for (Map.Entry<Socket, String> entry : map.entrySet()) {
                        if (entry.getValue().equals(n)){
                            send(entry.getKey().getOutputStream(), 8, content);
                            found = true;
                            break;
                        }
                    }
                    if (!found){
                        logger.error("聊天室没有这个人！");
                         send(out, 8, "聊天室没有这个人！");
                    }
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
