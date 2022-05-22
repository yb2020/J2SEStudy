package com.gebilaoyi.j2se.lesson1;

import javax.swing.*;
import java.awt.*;

/**
 * @author bingyi
 * @date 2022/3/31
 * J2SEStudy
 **/
public class MyLesson1 {
    public static void main(String args[]) {
        JFrame jFrame = new JFrame() ;
        jFrame.setSize(200, 300);
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("这是一个按钮");
        jButton.setSize(120, 200);
        jPanel.add(jButton) ;
        jPanel.setBackground(new Color(100, 150, 245));
        jPanel.setLayout(new GridLayout(4 , 5 , 2 , 2));
        jFrame.add(jPanel , BorderLayout.CENTER) ;
        jFrame.show();
    }
}
