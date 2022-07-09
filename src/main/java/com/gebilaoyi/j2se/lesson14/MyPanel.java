package com.gebilaoyi.j2se.lesson14;

import com.gebilaoyi.j2se.lesson13.MyArraylist;
import com.gebilaoyi.j2se.lesson13.MyListInterface;

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
    MyListInterface list = new MyLinkedList();

    int gb = 0 ;
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int x = 0;
        int y = 20;
        for(int i = 0 ; i < list.size(); i ++) {
            if(list.get(i).equals("\n")) {
                x = 0;
                y += 20;
            }else {
                g.drawString(list.get(i), (x + 1) * 10, y);
                x ++ ;
            }
        }
        if(gb < list.size()) {
            x = 0;
            y =20;
            for(int i = 0 ; i < gb; i ++) {
                if(list.get(i).equals("\n")) {
                    x = 0;
                    y += 20;
                }else {
                    x ++ ;
                }
            }
            g.drawLine(10 + x * 10, y - 10, 10 + x * 10, y + 2);
        }else {
            g.drawLine(10 + x * 10, y - 10, 10 + x * 10, y + 2);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() >= KeyEvent.VK_A && e.getKeyCode() <= KeyEvent.VK_Z) {
            list.add(gb, e.getKeyChar() + "");
            gb ++;
        }
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            list.remove(gb - 1);
            gb --;
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            list.add("\n");
            gb ++;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(gb > 0) {
                gb --;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(gb < list.size()) {
                gb ++;
            }
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
