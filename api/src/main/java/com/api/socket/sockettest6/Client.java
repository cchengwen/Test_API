package com.api.socket.sockettest6;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private JFrame clientFrame;
    private JLabel IPLabel;
    private JLabel PortLabel;
    private JLabel sayLabel;
    private JLabel nickNameLabel;
    private JTextField IPText;
    private JTextField PortText;
    private JTextField nickNameText;
    private JTextField sayText;
    private JButton connectButton;
    private JButton nicknameButton;
    private JButton sayButton;
    private JPanel jPanelNorth;
    private JPanel jPanelSouth0;
    private JPanel jPanelSouth1;
    private JPanel jPanelSouth2;
    private JTextArea clientTtextArea;
    private JScrollPane scroller;
    private BufferedReader reader;
    private PrintWriter writer;
    private String nickname;

    //  构造方法，初始化组件
    public Client() {
        nickname = "客户端";
        clientFrame = new JFrame();
        jPanelNorth = new JPanel();
        IPLabel = new JLabel("服务器IP", JLabel.LEFT);
        IPText = new JTextField(10);
        PortLabel = new JLabel("服务器端口", JLabel.LEFT);
        PortText = new JTextField(10);
        connectButton = new JButton("连接");
        clientTtextArea = new JTextArea();
        scroller = new JScrollPane(clientTtextArea);
        jPanelSouth0 = new JPanel();
        jPanelSouth1 = new JPanel();
        jPanelSouth2 = new JPanel();
        nickNameLabel = new JLabel("昵称", JLabel.LEFT);
        nickNameText = new JTextField(nickname, 30);
        nicknameButton = new JButton("确认");
        sayLabel = new JLabel("消息", JLabel.LEFT);
        sayText = new JTextField(30);
        sayButton = new JButton("确认");
    }

    //  构建GUI
    private void buildGUI() {
        //  窗口的设置
        clientFrame.setTitle("客户端");
        clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientFrame.setSize(550, 550);
        //　北区组件
        jPanelNorth.add(IPLabel);
        jPanelNorth.add(IPText);
        jPanelNorth.add(PortLabel);
        jPanelNorth.add(PortText);
        jPanelNorth.add(connectButton);
        clientFrame.getContentPane().add(BorderLayout.NORTH, jPanelNorth);
        //  中间组件
        clientTtextArea.setFocusable(false);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        clientFrame.getContentPane().add(BorderLayout.CENTER, scroller);
//        //  南区组件
        jPanelSouth1.add(nickNameLabel);
        jPanelSouth1.add(nickNameText);
        jPanelSouth1.add(nicknameButton);
        jPanelSouth2.add(sayLabel);
        jPanelSouth2.add(sayText);
        jPanelSouth2.add(sayButton);
        jPanelSouth0.setLayout(new BoxLayout(jPanelSouth0, BoxLayout.Y_AXIS));
        jPanelSouth0.add(jPanelSouth1);
        jPanelSouth0.add(jPanelSouth2);
        clientFrame.getContentPane().add(BorderLayout.SOUTH, jPanelSouth0);
        //  设置窗口可见
        clientFrame.setVisible(true);
    }

    //  客户端运行
    public void startUp() {
        System.out.println("客户端已启动 ...");
        buildGUI();
        //  接收服务器消息的线程
        Runnable incomingReader = new Runnable() {
            @Override
            public void run() {
                String message;
                try {
                    while ((message = reader.readLine()) != null) {
                        System.out.println("接收服务器的消息："+message);
                        clientTtextArea.append(message + "\n");
                    }
                } catch (Exception e) {
                }
            }
        };

        // 监听connect 按钮， 实现服务器的连接
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serverIp = IPText.getText();
                String serverPort = PortText.getText();
                if (serverIp.isEmpty() || serverPort.isEmpty() || StringUtils.isBlank(serverIp) || StringUtils.isBlank(serverPort)) {
                    JOptionPane.showMessageDialog(clientFrame, "请输入完整的ip和端口");
                } else {
                    try {
                        @SuppressWarnings("resource")
                        Socket clientSocket = new Socket(serverIp, Integer.parseInt(serverPort));
                        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
                        writer = new PrintWriter(clientSocket.getOutputStream());
                        clientTtextArea.append("服务器已接连 ... \n");

                        //   启动接收服务器线程
                        Thread thread = new Thread(incomingReader);
                        thread.start();
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(clientFrame, "连接不上服务器!\n请确认 IP 和 端口 输入正确。");
                    }
                }
            }
        });
        //  监听nickname,设置昵称
        ActionListener nicknameListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aText = nickNameText.getText();
                logger.info("设置客户端昵称1：[{}]", aText);
                if (!"".equals(aText)) nickname = aText;
            }
        };
        nicknameButton.addActionListener(nicknameListener);
        nickNameText.addActionListener(nicknameListener);
        nickNameText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                String bText = nickNameText.getText();
                logger.info("设置客户端昵称2：[{}]", bText);
                if (!"".equals(bText)) nickname = bText;
            }
        });

        //  发送消息到服务器
        ActionListener sayListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String aText = sayText.getText();
                if (aText.isEmpty() || StringUtils.isBlank(aText)) {
                    JOptionPane.showMessageDialog(clientFrame, "内容不能为空！");
                } else {
                    writer.println(nickname + ":" + aText);
                    writer.flush();
                    sayText.setText("");
                }
            }
        };
        sayButton.addActionListener(sayListener);
        sayText.addActionListener(sayListener);
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startUp();
    }
}
