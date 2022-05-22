package com.gebilaoyi.j2se.lesson2;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 * @date 2022/4/3
 * J2SEStudy
 **/
public class MyLesson2 extends JFrame {
    MyLesson2() {
        this.setSize(300, 300);
        MyPanel panel = new MyPanel();

        panel.setBackground(Color.black);
        this.add(panel);
        this.show();
    }
    public static void main(String args[]) {
        MyLesson2 myLesson2 = new MyLesson2() ;
    }
}
