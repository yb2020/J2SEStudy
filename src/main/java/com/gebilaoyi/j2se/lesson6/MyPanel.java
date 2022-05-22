package com.gebilaoyi.j2se.lesson6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author bingyi
 * @date 2022/5/14
 * J2SEStudy
 **/
public class MyPanel extends JPanel implements Runnable, KeyListener {
    int allAmount = 20 ; //生成字母的数量
    char[] words = new char[allAmount];
    int[] xArray = new int[allAmount];
    int[] yArray = new int[allAmount];
    boolean isFirst = true;
    int allCount = 0 ;
    int rightCount = 0;
    int errorCount = 0;
    int status = 0 ; //status 0等待开始，1进行中，2暂停
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
//        char tmp = 'z';
        //a是97 , z是122
        //keyboard code z是65, z是90
//        String s = "aslkdjflksdjfl";
//        char tmpS = 's';
//        char tmpL = 'l';
//        [tmpA, tmpS, tmpL...] = s
        //1.预先生成一批字母
        if(isFirst) {
            for(int i = 0 ; i < allAmount; i++) {
                words[i] = (char)(int)(Math.random() * 26 + 97);
                xArray[i] = (int) (Math.random() * 300);
                yArray[i] = (int) (Math.random() * 150);
                g.drawString(words[i] + "", xArray[i], yArray[i]);
            }
            isFirst = false;
        }else {
            for(int i = 0 ; i < allAmount; i++) {
                g.drawString(words[i] + "", xArray[i], yArray[i]);
            }
        }

        //2.计分，等待开始，暂停，进行中
        g.setColor(Color.red);
        if(status == 0) {
            g.drawString("游戏状态：等待开始", 10, 280);
        }else if(status == 1) {
            g.drawString("游戏状态：进行中", 10, 280);
        }else{
            g.drawString("游戏状态：暂停", 10, 280);
        }

        g.setColor(Color.green);
        g.drawString("总计：" + allCount, 10, 300);
        g.drawString("对的：" + rightCount, 10, 320);
        g.drawString("错的：" + errorCount, 10, 340);
        g.drawString("计分：" + (rightCount - errorCount) * 10, 10, 360);

    }

    @Override
    public void run() {
        while(true) {
            if(status == 1) {
                for(int i = 0 ; i < allAmount; i++) {
                    if(i % 2 == 0) {
                        yArray[i] ++ ;
                    }else {
                        yArray[i] += 2 ;
                    }
                    if(yArray[i] > 480) {
                        words[i] = (char)(int)(Math.random() * 26 + 97);
                        xArray[i] = (int) (Math.random() * 300);
                        yArray[i] = 0;
                        errorCount ++;
                    }
                }
            }
            this.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 32) {
            if(status == 0) {
                //启动
                status = 1;
            }else if(status == 1) {
                //暂停
                status = 2;
            }else if(status == 2) {
                //再次继续
                status = 1;
            }
        }

        if(status == 1) {
            int wordValue = e.getKeyCode() + 32;
            if(wordValue >= 97 && wordValue <= 122) {
                allCount ++;
                boolean hasError = true ;
                for(int i = 0 ; i < allAmount; i++) {
                    if(wordValue == (int)words[i]) {
                        words[i] = (char)(int)(Math.random() * 26 + 97);
                        xArray[i] = (int) (Math.random() * 300);
                        yArray[i] = 0;
                        rightCount ++;
                        hasError = false ;
                        break;
                    }
                }

                if(hasError) {
                    errorCount ++;
                }
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
