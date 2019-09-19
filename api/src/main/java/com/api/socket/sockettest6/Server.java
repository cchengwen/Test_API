package com.api.socket.sockettest6;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class Server {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private JFrame serverFrame;
    private JLabel portLabel;
    private JLabel sayLabel;
    private JLabel nicknameLabel;
    private JTextField portText;
    private JTextField sayText;
    private JTextField nicknameText;
    private JButton startButton;
    private JButton sayButton;
    private JButton nicknameButton;
    private JPanel jPanelNorth;
    private JPanel jPanelSouth0;
    private JPanel jPanelSouth1;
    private JPanel jPanelSouth2;
    private JScrollPane scroller;
    private JTextArea serverTextArea;
    private ArrayList<PrintWriter> clientOutputStream;
    private String nickname;

    //  实例化组件
    public Server() {
        nickname = "服务器端";
        serverFrame = new JFrame();
        jPanelNorth = new JPanel();
        portLabel = new JLabel("端口", JLabel.LEFT);
        portText = new JTextField(30);
        startButton = new JButton("开始");
        serverTextArea = new JTextArea();
        scroller = new JScrollPane(serverTextArea);
        nicknameLabel = new JLabel("昵称", JLabel.LEFT);
        nicknameText = new JTextField(nickname, 30);
        nicknameButton = new JButton("确认");
        jPanelSouth0 = new JPanel();
        jPanelSouth1 = new JPanel();
        jPanelSouth2 = new JPanel();
        sayLabel = new JLabel("消息", JLabel.LEFT);
        sayText = new JTextField(30);
        sayButton = new JButton("确认");
    }

    public void buildGUI() {
        //  窗口的设置
        serverFrame.setTitle("服务器");
        serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverFrame.setSize(550, 550);
        //  北区的组件
        jPanelNorth.add(portLabel);
        jPanelNorth.add(portText);
        jPanelNorth.add(startButton);
        serverFrame.getContentPane().add(BorderLayout.NORTH, jPanelNorth);
        //  中间组件
//        serverTextArea.setFocusable(false);
        serverTextArea.setFocusable(false);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        serverFrame.getContentPane().add(BorderLayout.CENTER, scroller);
        // 南区组件
        jPanelSouth1.add(nicknameLabel);
        jPanelSouth1.add(nicknameText);
        jPanelSouth1.add(nicknameButton);
        jPanelSouth2.add(sayLabel);
        jPanelSouth2.add(sayText);
        jPanelSouth2.add(sayButton);
        jPanelSouth0.setLayout(new BoxLayout(jPanelSouth0, BoxLayout.Y_AXIS));
        jPanelSouth0.add(jPanelSouth1);
        jPanelSouth0.add(jPanelSouth2);
        serverFrame.getContentPane().add(BorderLayout.SOUTH, jPanelSouth0);
        //  设置窗口可见
        serverFrame.setVisible(true);
    }

    public void startUp() {
        System.out.println("服务器已启动 ....");
        buildGUI();
        //  监听start按钮， 建立端口
        ActionListener startListener = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientOutputStream = new ArrayList<>();
                String aPort = portText.getText();
                if (aPort.isEmpty() || StringUtils.isBlank(aPort)) {
                    JOptionPane.showMessageDialog(serverFrame, "请输入正确的端口号！");
                } else {
                    //  等待客户端连接的线程
                    Runnable serverRunnable = new Runnable() {
                        @Override
                        public void run() {
                            ServerSocket serverSocket;
                            try {
                                serverSocket = new ServerSocket(Integer.parseInt(aPort));
                                serverTextArea.append("等待客户端连... \n");
                                while (true) {
                                    System.out.println("等待客户端连接 ....");
                                    Socket socket = serverSocket.accept();
                                    serverTextArea.append("客户端已连接 ... \n");
                                    System.out.println("一个客户端连接了 ....");
                                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                                    clientOutputStream.add(writer);
                                    //   客户端线程
                                    ClientHandler handler = new ClientHandler(socket);
                                    Thread thread = new Thread(handler);
                                    thread.start();
                                }
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                        }
                    };
                    Thread serverThread = new Thread(serverRunnable);
                    serverThread.start();
                }
            }
        };

        startButton.addActionListener(startListener);
        portText.addActionListener(startListener);

        //  监听nickname, 设置昵称
        ActionListener nicknameListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aText = nicknameText.getText();
                logger.info("设置服务器昵称1 --> [{}]", aText);
                if (!"".equals(aText)) {
                    nickname = aText;
                }
            }
        };
        nicknameButton.addActionListener(nicknameListener);
        nicknameText.addActionListener(nicknameListener);
        nicknameText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                String bText = nicknameText.getText();
                logger.info("设置服务器昵称：--> [{}]", bText);
                if (!"".equals(bText)) nickname = bText;

            }
        });

        //  监听say按钮，发送消息
        ActionListener sayListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aText = sayText.getText();
                if (!"".equals(aText)) {
                    aText = nickname + ": " + aText;
                    // 发送消息给所有客户端的方法
                    sendToEveryClient(aText);
                    serverTextArea.append(aText + "\n");
                    sayText.setText("");
                } else {
                    JOptionPane.showMessageDialog(serverFrame, "内容不能为空！");
                }
            }
        };
        sayButton.addActionListener(sayListener);
        sayText.addActionListener(sayListener);
    }

    //  多客户端的线程
    public class ClientHandler implements Runnable {
        private BufferedReader reader;
        private Socket socket;

        public ClientHandler(Socket socket) {
            socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    //  发送消息给所有客户端的方法
                    sendToEveryClient(message);
                    serverTextArea.append(message+"\n");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 发送消息给所有客户端的方法
    private void sendToEveryClient(String message){
        Iterator<PrintWriter> iterator = clientOutputStream.iterator();
        while (iterator.hasNext()){
            logger.info("发送给客户端的消息：--> [{}]", message);
            PrintWriter writer = iterator.next();
            writer.println(message);
            writer.flush();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.startUp();
    }
}
