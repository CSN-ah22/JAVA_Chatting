package com.daelim.five.Panel;

import com.daelim.five.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.net.Socket;

public class MainPanel extends JPanel {
    static JTextArea textArea;

    /*String return_talk;*/
    public MainPanel() {
        setView();

        setBackground(Color.pink);
        setSize(500, 500);
        setLayout(null);
    }


    private void setView() {
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(3, 10, 480, 300);
        add(scrollPane);


        JTextField text = new JTextField();
        text.setBounds(120, 350, 190, 30);
        add(text);

        /*엔터키 액션*/
        Action ok = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*textArea.append(text.getText()+"\n");*/
                Main.sendMessage(text.getText());
                text.setText("");
                textArea.setCaretPosition(textArea.getDocument().getLength());
                text.setText("");
            }
        };
        KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        text.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter, "ENTER");
        text.getActionMap().put("ENTER", ok);
        /*엔터키 액션 끝*/

        JButton submit = new JButton("전송");
        submit.setBounds(320, 350, 60, 30);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text.getText().equals("")) {
                    return;
                } else {
                    /* textArea.append(text.getText()+"\n");*/
                    Main.sendMessage(text.getText());
                    text.setText("");
                    textArea.setCaretPosition(textArea.getDocument().getLength()); //가장 마지막에 있는 text 값의 길이를 반환
                }

            }
        });
        add(submit);

        JButton bt_back = new JButton("로그인 화면으로 이동");
        bt_back.setBounds(120, 400, 260, 30);
        bt_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.movePage(1);
            }
        });
        add(bt_back);

    }

    public static void recvMsg(String s) {
        String my_id = Main.get_id();
        String[] strs = s.split("\\|");
        if (my_id.equals(strs[0])) {
            sss(strs);//내가 보낸 메세지를 표시할 경우
        } else{
            sss2(strs);//다른 사람이 보낸 메세지 표시할 경우
        }

    }

    public static void sss(String[] strs) {

        textArea.setFont(new Font("굴림체", Font.BOLD, 15));
        textArea.setForeground(Color.BLUE);
        textArea.append("나: " + strs[0] + "\n");
        textArea.append("보낸 시간: " + strs[1] + "\n");
        textArea.append("보낸 메시지: " + strs[2] + "\n");
        textArea.append("----------------------------" + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    public static void sss2(String[] strs) {
        textArea.setFont(new Font("굴림체", Font.BOLD, 15));
        textArea.setForeground(Color.BLUE);
        textArea.append("메세지 보낸 사람:" + strs[0] + "\n");
        textArea.append("보낸 시간: " + strs[1] + "\n");
        textArea.append("보낸 메시지: " + strs[2] + "\n");
        textArea.append("----------------------------" + "\n");
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
