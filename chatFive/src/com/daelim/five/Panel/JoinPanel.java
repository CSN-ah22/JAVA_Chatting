package com.daelim.five.Panel;

import com.daelim.five.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinPanel extends JPanel {
    public JoinPanel() {
        setView();

        setBackground(Color.LIGHT_GRAY);
        setSize(500, 500);
        setLayout(null);
    }

    private void setView() {
        /*아이디*/
        JLabel join_id = new JLabel("아이디:");
        join_id.setBounds(120, 100, 50, 30);
        add(join_id);

        JTextField id_field = new JTextField();
        id_field.setBounds(180, 100, 200, 30);
        add(id_field);
        /*아이디 END*/

        /*비밀번호*/
        JLabel join_pw = new JLabel("비밀번호:");
        join_pw.setBounds(120, 150, 70, 30);
        add(join_pw);

        JTextField pw_field = new JTextField();
        pw_field.setBounds(180, 150, 200, 30);
        add(pw_field);
        /*비밀번호 END*/

        /*아이디 확인*/
        JLabel check_id = new JLabel("아이디를 입력하여 주세요");
        check_id.setBounds(130, 200, 300, 30);
        check_id.setForeground(Color.RED);
        check_id.setVisible(false);
        add(check_id);

        /*비밀번호 확인*/
        JLabel check_pw2 = new JLabel("비밀번호를 입력하여 주세요");
        check_pw2.setBounds(130, 200, 300, 30);
        check_pw2.setForeground(Color.RED);
        check_pw2.setVisible(false);
        add(check_pw2);

        /*등록 확인*/
        JLabel register = new JLabel("등록되었습니다 로그인 창으로 돌아가주십시오");
        register.setBounds(130, 200, 600, 30);
        register.setForeground(Color.GREEN);
        register.setVisible(false);
        add(register);

        /*등록 버튼*/
        JButton join = new JButton("등록");
        join.setBounds(120, 300, 260, 30);
        join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (id_field.getText().equals("")) {
                    check_id.setVisible(true);
                    check_pw2.setVisible(false);

                } else if (pw_field.getText().equals("")) {
                    check_id.setVisible(false);
                    check_pw2.setVisible(true);

                } else {
                    check_id.setVisible(false);
                    check_pw2.setVisible(false);
                    register.setVisible(true);
                    join.setVisible(false);
                    System.out.println("JOIN_ID:" + id_field.getText());
                    System.out.println("JOIN_PW:" + pw_field.getText());
                }
            }/*actionPerformed*/
        });/*addActionListener*/
        add(join);
        /*등록 버튼 END*/

        /*로그인 화면으로 이동 버튼*/
        JButton bt_back = new JButton("로그인 화면으로 이동");
        bt_back.setBounds(120, 250, 260, 30);
        bt_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(1);
            }
        });

        add(bt_back);
    }
}
