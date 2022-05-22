package com.gebilaoyi.j2se.lesson5;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 * @date 2022/4/12
 * J2SEStudy
 **/
public class MyBall extends JFrame {
    MyBall() {
        this.setSize(300, 500) ;
        MyBallPanel panel = new MyBallPanel() ;
        panel.setBackground(Color.black);
        this.addMouseMotionListener(panel);
        this.addMouseListener(panel);
        this.addKeyListener(panel);
        //启动线程
        Thread t = new Thread(panel) ;
        t.start();
        this.add(panel);
        this.setVisible(true);
    }
    public static void main(String args[]) {
        MyBall myLesson5 = new MyBall();
    }
}
