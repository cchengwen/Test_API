package com.api.socket.sockettest5.notpacket;

import com.api.socket.util.CloseSocketUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Task implements Runnable {
    private Socket socket;
    final static ConcurrentHashMap<Socket, String> map = new ConcurrentHashMap<>();

    public Task(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        handle(socket);
        login(socket);
    }

    private static void handle(Socket socket) {
        OutputStream out = null;
        InputStream in = null;
        try {
            out = socket.getOutputStream();
            in = socket.getInputStream();
            byte[] by = new byte[1024 * 8];
            int len = 0;
            Set<Socket> socketSet = map.keySet();
            Socket socket1 = null;
            String s1, s2;
            //   读取请求
            while (true) {
                len = in.read(by);
                String s = new String(by, 0, len);
                switch (s) {
                    case "1":
                        //   响应名单
                        Collection<String> list = map.values();
                        out.write(list.toString().getBytes());
                        break;
                    case "2":  //  读取目的用户
                        len = in.read(by);
                        s1 = new String(by, 0, len);
                        out.write(s1.getBytes());
                        //  寻找目的用户的socket
                        for (Socket socket2 : socketSet) {
                            if (map.get(socket2).equals(s1)){
                                socket1 = socket2;
                                break;
                            }
                        }
                        //  读取内容
                        len = in.read(by);
                        s2 = new String(by, 0, len);
                        // 响应输出
                        OutputStream out1 = socket1.getOutputStream();
                        out1.write((map.get(socket)+":"+s2).getBytes());
                        break;
                    case "3":
                        len = in.read(by);
                        s2 = new String(by, 0, len);
                        for (Socket socket2 : socketSet) {
                            OutputStream out2 = socket2.getOutputStream();
                            out2.write((map.get(socket)+":"+s2).getBytes());
                        }
                        break;
                    case "4":
                        String s3 = map.get(socket);
                        map.remove(socket);
                        System.out.println(s3+"离开了！");
                        Thread thread = Thread.currentThread();
                        thread.stop();
                        break;
                }
            }
        } catch (IOException e) {
            CloseSocketUtil.close(in, out, socket);
        }
    }

    private static void login(Socket socket){
        OutputStream out = null;
        InputStream in = null;
        try {
            out = socket.getOutputStream();
            in = socket.getInputStream();
            byte[] by = new byte[1024*8];
            int len = in.read(by);
            String s = new String(by, 0, len);
            System.out.println(s+"连接了");
            map.put(socket, s);
            s = "欢迎："+s;
            out.write(s.getBytes());
        } catch (IOException e) {
            CloseSocketUtil.close(in, out,socket);
        }
    }
}
