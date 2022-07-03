package com.gebilaoyi.j2se.lesson12;

import javax.swing.*;

/**
 * @author bingyi
 * @date 2022/7/3
 * J2SEStudy
 **/
public class MyLesson12 extends JFrame {
    MyLesson12() {
        this.setSize(300, 400);
        this.setTitle("notepad");
        MyPanel mp = new MyPanel();

        this.addKeyListener(mp);
        this.add(mp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyLesson12 myLesson12 = new MyLesson12();
    }
}
