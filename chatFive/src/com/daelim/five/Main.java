package com.daelim.five;

import com.daelim.five.Panel.JoinPanel;
import com.daelim.five.Panel.LoginPanel;
import com.daelim.five.Panel.MainPanel;
import com.daelim.five.Panel.SettingPanel;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static WebSocketClient ws;
    static String user = "";
    static String s_s;

    public static JFrame f;
    private static LoginPanel loginPage;
    private static MainPanel mainPage;
    private static JoinPanel joinPage;
    private static SettingPanel settingPage;
    private static String URI;

    public static void uri(String uri) {
        URI = uri;
    }

    public static void main(String[] args) {
        f = new JFrame();

        loginPage = new LoginPanel();
        f.add(loginPage);
        mainPage = new MainPanel();
        f.add(mainPage);
        joinPage = new JoinPanel();
        f.add(joinPage);
        settingPage = new SettingPanel();
        f.add(settingPage);

        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        movePage(1);
    }

    public static void movePage(int index) {
        loginPage.setVisible(false);
        mainPage.setVisible(false);
        joinPage.setVisible(false);
        settingPage.setVisible(false);

        switch (index) {
            case 1:
                f.setTitle("Chat - 로그인 화면");
                loginPage.setVisible(true);
                break;
            case 2:
                f.setTitle("Chat - 체팅 화면");
                mainPage.setVisible(true);
                break;
            case 3:
                f.setTitle("Chat - 회원가입 화면");
                joinPage.setVisible(true);
                break;
            case 4:
                f.setTitle("Chat - 환경설정 화면");
                settingPage.setVisible(true);
                break;
        }

    }

    public static void connect(String userID) {
        user = userID;
        /*웹 소켓 연결 시작*/
        try {

            System.out.println("Main 에서의 uri: " + URI);
            /*"ws://www.yunholand.com:4877"*/
            ws = new WebSocketClient(new URI(URI)) {
                @Override
                //websocket 서버 연결 후 동작 정의
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("open");
                    System.out.println("😀" + user + "|서버 접속!");
                    movePage(2);

                }

                @Override
                //server에서 메시지 받았을시 동작 정의
                public void onMessage(String s) {
                    s_s = s;
                    String[] strs = s.split("\\|");
                    if (strs[0].equals(user)) {
                        System.out.println("나:" + strs[0]);
                    } else {
                        System.out.println("메세지 보낸 사람:" + strs[0]);
                    }
                    System.out.println("보낸 시간:" + strs[1]);
                    System.out.println("보낸 메세지:" + strs[2]);
                    System.out.println("------------------");
                    MainPanel.recvMsg(s);

                }

                @Override
                //server 연결 종료 후 동작 정의
                public void onClose(int i, String s, boolean b) {
                    System.out.println("onclose");
                }

                @Override
                //예외 발생시 동작 정의
                public void onError(Exception e) {
                    System.out.println("error");
                }
            };

            ws.connect();
            ws.close();

        } catch (Exception e) {

        }
        /*웹 소켓 끝*/
    }

    public static void sendMessage(String msg) {
        String nowTime = "";
        nowTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        ws.send(user + "|" + nowTime + "|" + msg);

    }

    public static String get_id() {
        return user;
    }


}
