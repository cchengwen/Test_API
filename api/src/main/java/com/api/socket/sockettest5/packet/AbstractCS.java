package com.api.socket.sockettest5.packet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public abstract class AbstractCS {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 接收消息
     *
     * @param socket
     * @param in     输入流
     * @param out    输出流
     * @throws IOException
     */
    public void receive(Socket socket, InputStream in, OutputStream out) throws IOException {
        while (true) {
            int cmd = in.read();
            if (cmd == -1) break;

            int hi = in.read();
            int lo = in.read();
            int length = (hi << 8) + lo;
            byte[] by = new byte[length];
            in.read(by);
            String s = new String(by, "UTF-8");
            logger.info("接收的消息：[{}]", s);
            handle(socket, out, cmd, s);
        }
    }

    /**
     * 发送消息
     *
     * @param out     输出流
     * @param cmd
     * @param content
     * @throws IOException
     */
    public void send(OutputStream out, int cmd, String content) throws IOException {
        logger.info("cmd -> [{}], content -> [{}]", cmd, content);
        out.write(cmd);
        byte[] bytes = content.getBytes();
        int len = bytes.length;
        out.write(0XFF & len >> 8);
        out.write(0XFF & len);
        out.write(bytes);
    }

    /**
     * 自定义接受消息后的处理
     *
     * @param socket
     * @param out    输出流
     * @param cmd
     * @param str
     */
    public abstract void handle(Socket socket, OutputStream out, int cmd, String str);


}
