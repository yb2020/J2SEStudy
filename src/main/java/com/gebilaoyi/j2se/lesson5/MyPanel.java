package com.gebilaoyi.j2se.lesson5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author bingyi
 * @date 2022/4/12
 * J2SEStudy
 **/
public class MyPanel extends JPanel implements MouseListener, KeyListener {
    int x = 100;
    int y = 100;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX() ;
        y = e.getY() - 20;
        this.repaint();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 37) {
            if(x >= 10) {
                x -= 10 ;
            }
        }
        if(e.getKeyCode() == 38) {
            if(y >= 10) {
                y -= 10 ;
            }
        }
        if(e.getKeyCode() == 39) {
            if(x < 280) {
                x = x + 10 ;
            }
        }
        if(e.getKeyCode() == 40) {
            if(y < 450) {
                y += 10 ;
            }
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
