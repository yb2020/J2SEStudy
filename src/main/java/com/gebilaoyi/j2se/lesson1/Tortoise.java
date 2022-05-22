package com.gebilaoyi.j2se.lesson1;

import javafx.stage.WindowEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

/**
 * @author bingyi
 * @date 2022/3/31
 * J2SEStudy
 **/
public class Tortoise extends JFrame{
    static Container c;

    public Tortoise() {
        setBackground(Color.white);
        setTitle("王八");
        setSize(300, 180);
        //利用匿名类处理事件
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        Container c = this.getContentPane();
        c.add(new yuTestPanel());
    }

    public static void main(String arge[]) {
        new Tortoise().show();

    }
}

class yuTestPanel extends JPanel {
    public void paint(Graphics g) {
        super.paint(g);
        Font f = new Font("粗斜体", Font.ITALIC + Font.BOLD, 18);
        g.setFont(f);
        g.setColor(Color.green);//左上
        g.fillOval(160, 50, 20, 10);
        g.drawString("", 10, 20);
        g.setColor(Color.green);//右上
        g.fillOval(210, 50, 20, 10);
        g.drawString("", 10, 20);
        g.setColor(Color.green);//左下
        g.fillOval(160, 100, 20, 10);
        g.drawString("", 10, 20);
        g.setColor(Color.green);//右下
        g.fillOval(210, 100, 20, 10);
        g.drawString("", 10, 20);
        g.setColor(Color.green);// 头
        g.fillRect(190, 32, 10, 10);
        g.setColor(Color.green);// 头
        g.fillOval(188, 20, 15, 15);
        g.setColor(Color.black);// 眼睛左
        g.fillOval(191, 25, 2, 2);
        g.setColor(Color.black);// 眼睛右
        g.fillOval(199, 25, 2, 2);
        g.setColor(Color.blue);// 尾巴
        g.drawOval(200, 120, 17, 17);
        g.setColor(Color.BLUE);
        g.drawArc(195, 90, 40, 50, 190, 150);
        g.setColor(Color.red);//身体
        g.fillOval(165, 40, 60, 80);
    }
}
