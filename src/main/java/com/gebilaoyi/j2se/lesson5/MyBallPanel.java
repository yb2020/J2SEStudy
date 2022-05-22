package com.gebilaoyi.j2se.lesson5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author bingyi
 * @date 2022/4/12
 * J2SEStudy
 **/
public class MyBallPanel extends JPanel implements Runnable, MouseListener,MouseMotionListener,KeyListener {
    int x = (300-20)/2;
    int y = 440;
    int direct = 1 ; // 1.左上，2.右上，3.右下，4，左下
    int speed = 8 ;
    int rectX = (300-60) / 2 ;
    boolean isClicked = false ;
    boolean isStarted = false ;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.white);
        g.fillOval(x, y, 20, 20);
        g.setColor(Color.blue);
        g.fillRect(rectX, 460, 60, 10);
    }

    @Override
    public void run() {
        while(true) {
            if (isStarted) {
                if (direct == 1) {
                    x -= speed;
                    y -= speed;
                }
                if (direct == 2) {
                    x += speed;
                    y -= speed;
                }
                if (direct == 3) {
                    x += speed;
                    y += speed;
                }
                if (direct == 4) {
                    x -= speed;
                    y += speed;
                }
                if (x < 0) {
                    if (direct == 1) {
                        direct = 2;
                    } else {
                        direct = 3;
                    }
                }
                if (y < 0) {
                    if (direct == 2) {
                        direct = 3;
                    } else {
                        direct = 4;
                    }
                }
                if (x > 280) {
                    if (direct == 3) {
                        direct = 4;
                    } else {
                        direct = 1;
                    }
                }
                if (y > 440) {
                    //判断小球的x坐标是否在挡板的范围
                    if(x > rectX && x < rectX + 60 && x + 20 > rectX && (x + 20 < rectX + 60)) {
                        if (direct == 4) {
                            direct = 1;
                        } else {
                            direct = 2;
                        }
                    }else {
                        //游戏结束
                        isStarted = false;
                         x = (300-20)/2;
                         y = 440;
                         direct = 1 ; // 1.左上，2.右上，3.右下，4，左下
                         speed = 8 ;
                         rectX = (300-60) / 2 ;
                         isClicked = false ;
                         isStarted = false ;
                    }

                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(isClicked) {
            rectX = e.getX() - 60 / 2;
            if(rectX < 0) {
                rectX = 0;
            }
            if(rectX > 240) {
                rectX = 240;
            }
            if(!isStarted) {
                x = e.getX() - 20 / 2;
                if(x < 20) {
                    x = 20;
                }
                if(x > 260) {
                    x = 260;
                }
            }
            this.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        isClicked = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isClicked = false;
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
        if(e.getKeyCode() == 32) {
            //启动
            isStarted = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
