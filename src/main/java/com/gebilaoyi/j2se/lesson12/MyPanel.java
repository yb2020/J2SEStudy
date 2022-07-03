package com.gebilaoyi.j2se.lesson12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author bingyi
 * @date 2022/7/3
 * J2SEStudy
 **/
public class MyPanel extends JPanel implements KeyListener {
    String[] text = new String[100];
    int p = 0 ;
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int x = 0;
        int y = 20;
        for(int i = 0 ; i < p; i ++) {
            if(text[i].equals("\n")) {
                x = 0;
                y += 20;
            }else {
                g.drawString(text[i], (x + 1) * 10, y);
                x ++ ;
            }
        }
        g.drawLine(10 + x * 10, y - 10, 10 + x * 10, y + 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z) {
            System.out.println(e.getKeyChar());
            text[p] = e.getKeyChar() + "";
            p ++;
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE && p > 0) {
            p --;
            text[p] = "";
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            text[p] = "\n";
            p ++;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
