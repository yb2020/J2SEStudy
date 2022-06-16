package com.gebilaoyi.j2se.lesson10.part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/**
 * @author bingyi
 * @date 2022/6/9
 * J2SEStudy
 **/
public class QQMain2 extends JFrame implements ActionListener, Runnable {
    JTextField tt = new JTextField() ;
    JTextArea ta = new JTextArea() ;
    JComboBox cb = new JComboBox() ;
    String username;
    Socket s ;
    String splitLabel = "#split#";
    QQMain2(String username, Socket s) {
        //设置窗体属性
        this.setSize(400 , 500) ;
        this.setResizable(false) ;
        int with = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
        int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() ;
        this.setLocation((with - 400) / 2 , (height - 500) / 2) ;
        this.setTitle(username);
        this.username = username;
        this.s = s;

        //new一大堆组件
        JButton bb = new JButton("发送") ;
        JScrollPane sp = new JScrollPane(ta) ;

        //注册事件监听
        bb.addActionListener(this) ;

        cb.addItem("All") ;

        //布置输入面板
        JPanel input = new JPanel() ;
        input.setLayout(new GridLayout(1 , 2)) ;
        input.add(cb) ;
        input.add(bb) ;

        //布置大面板
        JPanel big = new JPanel() ;
        big.setLayout(new BorderLayout()) ;
        big.add(input , BorderLayout.NORTH) ;
        big.add(sp , BorderLayout.CENTER) ;

        //布置窗体
        this.setLayout(new BorderLayout()) ;
        this.add(big , BorderLayout.CENTER) ;
        this.add(tt , BorderLayout.NORTH) ;

        Thread t = new Thread(this);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        String message = tt.getText();
        if(!message.equals("")) {
            try {
                OutputStream osPushMe = s.getOutputStream();
                PrintWriter pwPushMe = new PrintWriter(osPushMe, true) ;
                pwPushMe.println(cb.getSelectedItem() + splitLabel + username + splitLabel + message);
            }catch(Exception ex) {

            }

        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                InputStream is = s.getInputStream();
                InputStreamReader isr = new InputStreamReader(is) ;
                BufferedReader br = new BufferedReader(isr);

                String res = br.readLine();
                String[] resArray = res.split(splitLabel) ;
                switch (resArray[0]) {
                    case "UserOnline":
                        cb.addItem(resArray[1]);
                        break ;
                    case "UserMessage":
                        ta.append(resArray[1] + "\n");
                        break;
                }
            }catch(Exception ex) {
                
            }
        }
    }
}
