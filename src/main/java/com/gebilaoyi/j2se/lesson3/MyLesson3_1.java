package com.gebilaoyi.j2se.lesson3;

import javax.swing.*;

/**
 * @author bingyi
 * @date 2022/4/5
 * J2SEStudy
 **/
public class MyLesson3_1 extends JFrame {
    MyLesson3_1() {
        this.setSize(800, 600);
        this.setTitle("画一个圆");
        MyPanel3_1 myPanel = new MyPanel3_1();
        this.addMouseListener(myPanel) ; //添加鼠标事件
        this.addMouseMotionListener(myPanel);
        this.add(myPanel) ; //添加面板
        this.setVisible(true);
    }
    public static void main(String args[]) {
        MyLesson3_1 myLesson3 = new MyLesson3_1();
    }
}
