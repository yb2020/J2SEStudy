package com.gebilaoyi.j2se.lesson14;

import javax.swing.*;

/**
 * @author bingyi
 * @date 2022/7/3
 * J2SEStudy
 **/
public class MyLesson14 extends JFrame {
    MyLesson14() {
        this.setSize(300, 400);
        this.setTitle("notepad LinkedList");
        MyPanel mp = new MyPanel();

        this.addKeyListener(mp);
        this.add(mp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyLesson14 myLesson14 = new MyLesson14();
    }
}
