package com.gebilaoyi.j2se.lesson6;


import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 * @date 2022/5/14
 * J2SEStudy
 **/
public class MyLesson6 extends JFrame {
    MyLesson6() {
        this.setSize(300, 500);
        MyPanel myPanel = new MyPanel();
        myPanel.setBackground(Color.black);
        this.addKeyListener(myPanel);
        Thread t = new Thread(myPanel);
        t.start();
        this.add(myPanel);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        MyLesson6 myLesson6 = new MyLesson6();
    }

}
