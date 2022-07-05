package com.gebilaoyi.j2se.lesson13;

import javax.swing.*;

/**
 * @author bingyi
 * @date 2022/7/3
 * J2SEStudy
 **/
public class MyLesson13 extends JFrame {
    MyLesson13() {
        this.setSize(300, 400);
        this.setTitle("notepad arraylist");
        MyPanel mp = new MyPanel();

        this.addKeyListener(mp);
        this.add(mp);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyLesson13 myLesson13 = new MyLesson13();
    }
}
