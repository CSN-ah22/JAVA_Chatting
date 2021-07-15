package com.daelim.five.Panel;

import com.daelim.five.Data.SettingData;
import com.daelim.five.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SettingPanel extends JPanel {
    private JTextField server, port;
    public String line = "";

    public SettingPanel() {
        setView();

        setBackground(Color.PINK);
        setSize(500, 500);
        setLayout(null);
    }

    private void setView() {
        JLabel label_server = new JLabel("SERVER");
        label_server.setBounds(120, 100, 60, 30);
        add(label_server);
        server = new JTextField();
        server.setBounds(180, 100, 200, 30);
        add(server);
        JLabel label_port = new JLabel("PORT");
        label_port.setBounds(120, 150, 60, 30);
        add(label_port);
        port = new JTextField();
        port.setBounds(180, 150, 200, 30);
        add(port);


        JButton bt_save = new JButton("저장");
        bt_save.setBounds(120, 220, 260, 30);
        bt_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("server : " + server.getText()
                        + ", PORT : " + port.getText());

                if (server.getText().equals("")) {
                    JOptionPane.showMessageDialog(
                            Main.f, "서버 정보가 입력되지 않았습니다.");
                    return;
                }
                if (port.getText().equals("")) {
                    JOptionPane.showMessageDialog(
                            Main.f, "포트 정보가 입력되지 않았습니다.");
                    return;
                }

                try {
                    String path = "D://settingData.txt";

                    /*파일 쓰기 시작*/
                    /*byte utf8Bytes[] = server.getText().getBytes("utf-8");
                    SettingData data;
                    data = new SettingData((server.getText()+new String(utf8Bytes,"utf-8")), port.getText());

                    ObjectOutputStream out = new ObjectOutputStream(
                            new FileOutputStream("D://settingData.txt")
                    );
                    out.writeObject(data);
                    out.close();*/
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                            new FileOutputStream(path), "utf-8"));
                    writer.write("ws://" + server.getText() + ":" + port.getText());
                    writer.close();

                    /*파일 쓰기 끝*/

                    /*저장 되었습니다 출력*/
                    JOptionPane.showMessageDialog(Main.f, "저장 되었습니다");

                    Main.movePage(1);

                    /*파일읽기_start*/

                    BufferedReader reader = new BufferedReader(new InputStreamReader(
                            new FileInputStream(path), "utf-8"));
                    
                    line = reader.readLine();
                    Main.uri(line);
                    reader.close();

                    /* 파일 읽기 시행 착오
                    char[] cbuf = new char[10]; // 최대 10개의 문자 읽어 저장
                int readCnt=0;
                Reader reader;
                try {
                    reader = new FileReader("D://settingData.txt");

                    readCnt = reader.read(cbuf, 0, cbuf.length);
                    for (int i = 0; i < readCnt; i++) {
                        System.out.print("setting: " + cbuf[i]);
                    }
                    reader.close();
                    System.out.println("\n파일 읽기 끝");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }*/

                    /*파일읽기_end*/

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(
                            Main.f, "파일이 정상적으로 생성되지 않았습니다.");
                    return;
                }


            }
        });
        add(bt_save);


        JButton bt_back = new JButton("취소");
        bt_back.setBounds(120, 260, 260, 30);
        bt_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(1);
            }
        });
        add(bt_back);
    }

}
