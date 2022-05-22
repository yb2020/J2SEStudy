package com.gebilaoyi.j2se.lesson3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author bingyi
 * @date 2022/4/5
 * J2SEStudy
 **/
public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
    int x, y, endX, endY; //全局变量
    int buttonType;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println(buttonType);
        if(buttonType == 3) {
            g.drawLine(x, y, endX , endY);
        }else {
            if(x < endX) {
                if(y < endY) {
                    g.drawOval(x, y, endX - x, endY - y);
                }else {
                    g.drawOval(x, endY, endX - x, y - endY);
                }
            }else {
                if(y < endY) {
                    g.drawOval(endX, y, x - endX , endY -y);
                }else {
                    g.drawOval(endX, endY, x - endX , y - endY);
                }

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttonType = e.getButton();
        System.out.println(buttonType);
        x = e.getX() ;
        y = e.getY() ;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        buttonType = e.getButton();
        endX = e.getX() ;
        endY = e.getY() ;
        this.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        buttonType = e.getButton();
        endX = e.getX();
        endY = e.getY();
        this.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
