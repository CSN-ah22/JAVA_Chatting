package com.daelim.five.Panel;

import com.daelim.five.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class LoginPanel extends JPanel {
    public String line = "";

    public LoginPanel() {
        setView();

        setBackground(Color.ORANGE);
        setSize(500, 500);
        setLayout(null);
    }

    private void setView() {

        JLabel label_id = new JLabel("아이디:");
        label_id.setBounds(100, 100, 50, 30);
        add(label_id);
        JTextField idField = new JTextField();
        idField.setBounds(150, 100, 200, 30);
        add(idField);

        JLabel label_pw = new JLabel("비밀번호:");
        label_pw.setBounds(85, 150, 60, 30);
        add(label_pw);
        JTextField pwField = new JTextField();
        pwField.setBounds(150, 150, 200, 30);
        add(pwField);


        JButton bt_login = new JButton("로그인");
        bt_login.setBounds(120, 250, 260, 30);
        bt_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!idField.getText().equals("") &&
                        !pwField.getText().equals("")) {
                    System.out.println("아이디:" + idField.getText());
                    System.out.println("비밀번호: " + pwField.getText());

                    /*파일읽기_start*/
                    String path = "D://settingData.txt";
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(
                                new FileInputStream(path), "utf-8"));

                        line = reader.readLine();
                        Main.uri(line);
                        reader.close();

                        /*파일읽기_end*/
                    } catch (Exception ee) {

                    }
                    Main.movePage(2);
                    Main.connect(idField.getText());

                    /* 소켓 시행착오
                    try{
                            Socket s = new Socket("localhost", 4887);
                            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                            dout.writeUTF(idField.getText());
                            dout.flush();
                            dout.close();
                            s.close();

                    }catch (Exception ex){

                    }*/
                } else {
                    JOptionPane.showMessageDialog(Main.f, "아이디/비밀번호 정보가 없습니다.");
                }

            }
        });
        add(bt_login);
        JButton bt_join = new JButton("회원가입");
        bt_join.setBounds(120, 300, 260, 30);
        bt_join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(3);
            }
        });
        add(bt_join);
        JButton bt_setting = new JButton("환경설정");
        bt_setting.setBounds(120, 350, 260, 30);
        bt_setting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(4);
            }
        });
        add(bt_setting);

    }

}
