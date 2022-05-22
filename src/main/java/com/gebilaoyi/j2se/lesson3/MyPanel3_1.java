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
public class MyPanel3_1 extends JPanel implements MouseListener, MouseMotionListener {
    int x, y, endX, endY; //全局变量
    int buttonType;
    int ox[] = new int[100];
    int oy[] = new int[100];
    int oEndX[] = new int[100];
    int oEndY[] = new int[100];
    int oi = 0;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i < oi; i ++) {
            g.drawOval(ox[i], oy[i], oEndX[i], oEndY[i]);
        }
        if(buttonType == 3) {
            g.drawLine(x, y, endX , endY);
        }else {
            if(x < endX) {
                if(y < endY) {
                    ox[oi] = x ;
                    oy[oi] = y;
                    oEndX[oi] = endX - x;
                    oEndY[oi] = endY - y;
                }else {
                    ox[oi] = x ;
                    oy[oi] = endY;
                    oEndX[oi] = endX - x;
                    oEndY[oi] = y - endY;
                }
            }else {
                if(y < endY) {
                    ox[oi] = endX ;
                    oy[oi] = y;
                    oEndX[oi] = x - endX;
                    oEndY[oi] = endY -y;
                }else {
                    ox[oi] = endX ;
                    oy[oi] = endY;
                    oEndX[oi] = x - endX;
                    oEndY[oi] = y - endY;
                }
            }
            g.drawOval(ox[oi], oy[oi], oEndX[oi], oEndY[oi]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        buttonType = e.getButton();
        x = e.getX() ;
        y = e.getY() ;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        buttonType = e.getButton();
        endX = e.getX() ;
        endY = e.getY() ;
        oi ++ ;
        this.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
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
