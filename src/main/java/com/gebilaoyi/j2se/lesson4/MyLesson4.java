package com.gebilaoyi.j2se.lesson4;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 * @date 2022/4/9
 * J2SEStudy
 **/
public class MyLesson4 extends JFrame {
    MyLesson4() {
        this.setSize(300, 600);
        this.setTitle("下雪了");
        MyPanel panel = new MyPanel();
        panel.setBackground(Color.black);
        this.addMouseListener(panel);
        Thread t = new Thread(panel);
        t.start();
        this.add(panel);
        this.setVisible(true);
    }
    public static void main(String args[]) {
        MyLesson4 myLesson4 = new MyLesson4();
    }
}
