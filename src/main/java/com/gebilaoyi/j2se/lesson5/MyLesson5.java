package com.gebilaoyi.j2se.lesson5;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 * @date 2022/4/12
 * J2SEStudy
 **/
public class MyLesson5 extends JFrame {
    MyLesson5() {
        this.setSize(300, 500) ;
        MyPanel panel = new MyPanel() ;
        panel.setBackground(Color.black);
        this.addMouseListener(panel);
        this.addKeyListener(panel);
        this.add(panel);
        this.setVisible(true);
    }
    public static void main(String args[]) {
        MyLesson5 myLesson5 = new MyLesson5();
    }
}
