package com.gebilaoyi.j2se.lesson2;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //左上脚
        g.setColor(Color.green);
        g.fillOval(40, 40, 20, 10);
        //右上脚
        g.fillOval(120,40, 20, 10);
        //左下脚
        g.fillOval(40, 120, 20, 10);
        //右下脚
        g.fillOval(120, 120, 20, 10);
        //头
        g.fillOval(80, 5, 20 , 10);
        //脖子
        g.fillRect(85, 10, 10,20);
        g.setColor(Color.red);
        //身子
        g.fillOval(45, 25, 90, 120);
        g.setColor(Color.blue);
        //左眼睛
        g.fillOval(82, 7, 5, 5);
        //右眼睛
        g.fillOval(92, 7, 5, 5);
    }
}