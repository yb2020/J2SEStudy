package com.gebilaoyi.j2se.lesson10;

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
public class QQLogin extends JFrame implements ActionListener {
    JTextField t_username = new JTextField() ;
    JPasswordField t_password = new JPasswordField() ;
    QQLogin() {
        //设置窗体属性
        this.setSize(250 , 120) ;
        this.setResizable(false) ;
        int with = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
        int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() ;
        this.setLocation((with - 250) / 2 , (height - 120) / 2) ;

        //new一大堆组件
        JLabel l_username = new JLabel("用户名：") ;
        JLabel l_password = new JLabel("密　码：") ;


        JButton b_login = new JButton("登录") ;
        JButton b_reg = new JButton("注册") ;
        JButton b_cancel = new JButton("取消") ;

        //注册事件监听
        b_login.addActionListener(this) ;
        b_reg.addActionListener(this) ;
        b_cancel.addActionListener(this) ;

        //布置输入面板
        JPanel input = new JPanel() ;
        input.setLayout(new GridLayout(2 , 3)) ;
        input.add(l_username) ;
        input.add(t_username) ;

        input.add(l_password) ;
        input.add(t_password) ;

        //布置按钮面板
        JPanel button = new JPanel() ;
        button.setLayout(new FlowLayout()) ;
        button.add(b_login) ;
        button.add(b_reg) ;
        button.add(b_cancel) ;

        //布置窗体
        this.setLayout(new BorderLayout()) ;
        this.add(input , BorderLayout.CENTER) ;
        this.add(button , BorderLayout.SOUTH) ;
    }
    public static void main(String args[]) {
        QQLogin f = new QQLogin() ;
        f.setVisible(true) ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("登录")) {
            System.out.println(e.getActionCommand());
            String usn = t_username.getText();
            String pwd = t_password.getText();
            String label = "#split#";
            if(usn.equals("") || pwd.equals("")) {
                JOptionPane.showMessageDialog(this, "your username or password is null, please input it.");
            }else {
                try {
                    Socket s = new Socket("127.0.0.1", 8888);
                    OutputStream os = s.getOutputStream();
                    PrintWriter pw = new PrintWriter(os, true);
                    pw.println("Login" + label + usn + label + pwd);

                    InputStream is = s.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is) ;
                    BufferedReader br = new BufferedReader(isr) ;

                    String loginMessage = br.readLine();
                    if(loginMessage.equals("LoginOK")) {
                        System.out.println("登录成功");
                        QQMain main = new QQMain(usn, s);
                        main.setVisible(true);
                        this.setVisible(false);
                    }else {
                        JOptionPane.showMessageDialog(this, "your username or password is error, please try again.");
                        t_username.setText("");
                        t_password.setText("");
                        t_username.grabFocus();
                    }
                }catch (Exception ex) {

                }
            }

        }
        if(e.getActionCommand().equals("取消")) {
            System.exit(0);
        }
    }
}
