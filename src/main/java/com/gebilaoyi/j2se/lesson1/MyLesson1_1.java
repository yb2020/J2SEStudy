package com.gebilaoyi.j2se.lesson1;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 * @date 2022/3/31
 * J2SEStudy
 **/
public class MyLesson1_1 extends JFrame {
    public static void main(String[] args) {
        MyLesson1_1 myLesson1_1 = new MyLesson1_1();
        myLesson1_1.setSize(200, 300);
        JPanel jPanel = new JPanel() ;

        JButton button = new JButton("这是我第二个按钮");
        jPanel.add(button);

        jPanel.setBackground(new Color(100, 120, 80));
        myLesson1_1.add(jPanel);
        myLesson1_1.show();
    }
}
