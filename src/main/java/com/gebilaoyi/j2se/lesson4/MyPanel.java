package com.gebilaoyi.j2se.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author bingyi
 * @date 2022/4/9
 * J2SEStudy
 **/
public class MyPanel extends JPanel implements Runnable, MouseListener {
    int[] x = new int[100];
    int[] y = new int[100];
    boolean start = false;
    MyPanel() {
        for(int i = 0 ; i < 100; i ++) {
            x[i] = (int) (Math.random() * 300) ; //0 ~ 1 , 0.9829239239 * 300
            y[i] = (int) (Math.random() * 600) ;
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        for(int i  = 0 ; i < 100 ; i ++) {
            g.drawString("*", x[i], y[i]) ;
        }
    }

    @Override
    public void run() {
        while(true) {
            if (start) {
                for (int i = 0; i < 100; i++) {
                    y[i]++;
                    if (y[i] >= 600) {
                        x[i] = (int) (Math.random() * 300);
                        y[i] = 0;
                    }
                }
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.start = !this.start ;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
