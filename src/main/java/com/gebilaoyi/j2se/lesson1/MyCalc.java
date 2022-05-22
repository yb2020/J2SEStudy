package com.gebilaoyi.j2se.lesson1;

import java.awt.* ;
import javax.swing.* ;
import java.awt.event.*;

public class MyCalc extends JFrame implements ActionListener {
    JTextField tt = new JTextField() ;
    MyCalc() {
        //设置窗体属性
        this.setSize(354 , 220) ;
        this.setResizable(false) ;
        int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
        int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() ;
        this.setLocation((width - 350)/2 , (height - 220)/2) ;

        //new一大堆组件

        JButton b0 = new JButton("0") ;
        JButton b1 = new JButton("1") ;
        JButton b2 = new JButton("2") ;
        JButton b3 = new JButton("3") ;
        JButton b4 = new JButton("4") ;
        JButton b5 = new JButton("5") ;
        JButton b6 = new JButton("6") ;
        JButton b7 = new JButton("7") ;
        JButton b8 = new JButton("8") ;
        JButton b9 = new JButton("9") ;

        JButton bjia = new JButton("+") ;
        JButton bjian = new JButton("-") ;
        JButton bchen = new JButton("*") ;
        JButton bchu = new JButton("/") ;

        JButton bdengyu = new JButton("=") ;
        JButton bbaifen = new JButton("%") ;
        JButton bzhengfu = new JButton("-/+") ;
        JButton bdian = new JButton(".") ;
        JButton bfengshu = new JButton("1/x") ;
        JButton bsqrt = new JButton("sqrt") ;

        JButton bbackspace = new JButton("BackSpace") ;
        JButton bce = new JButton("CE") ;
        JButton bc = new JButton("C") ;

        JButton bmc = new JButton("MC") ;
        JButton bms = new JButton("MS") ;
        JButton bmr = new JButton("MR") ;
        JButton bmjia = new JButton("M+") ;

        //布置数字面板
        JPanel p_shuzhi = new JPanel() ;
        p_shuzhi.setLayout(new GridLayout(4 , 5 , 2 , 2)) ;

        p_shuzhi.add(b7) ;
        p_shuzhi.add(b8) ;
        p_shuzhi.add(b9) ;
        p_shuzhi.add(bchu) ;
        p_shuzhi.add(bsqrt) ;

        p_shuzhi.add(b4) ;
        p_shuzhi.add(b5) ;
        p_shuzhi.add(b6) ;
        p_shuzhi.add(bchen) ;
        p_shuzhi.add(bbaifen) ;

        p_shuzhi.add(b1) ;
        p_shuzhi.add(b2) ;
        p_shuzhi.add(b3) ;
        p_shuzhi.add(bjian) ;
        p_shuzhi.add(bfengshu) ;

        p_shuzhi.add(b0) ;
        p_shuzhi.add(bzhengfu) ;
        p_shuzhi.add(bdian) ;
        p_shuzhi.add(bjia) ;
        p_shuzhi.add(bdengyu) ;


        //布置记忆面板
        JPanel p_jiyi = new JPanel() ;
        p_jiyi.setLayout(new GridLayout(4 , 1)) ;
        p_jiyi.add(bmc) ;
        p_jiyi.add(bms) ;
        p_jiyi.add(bmr) ;
        p_jiyi.add(bmjia) ;

        //布置清除面板
        JPanel p_qingchu = new JPanel() ;
        p_qingchu.setLayout(new GridLayout(1 , 3)) ;
        p_qingchu.add(bbackspace) ;
        p_qingchu.add(bce) ;
        p_qingchu.add(bc) ;

        //布置大面板
        JPanel p_big = new JPanel() ;
        p_big.setLayout(new BorderLayout()) ;
        p_big.add(p_shuzhi , BorderLayout.CENTER) ;
        p_big.add(p_qingchu , BorderLayout.NORTH) ;
        p_big.add(p_jiyi , BorderLayout.WEST) ;

        //布置窗体
        this.setLayout(new BorderLayout()) ;
        this.add(p_big , BorderLayout.CENTER) ;
        this.add(tt , BorderLayout.NORTH) ;

        //设置其它属性
        tt.setEditable(false) ;
        tt.setHorizontalAlignment(JTextField.RIGHT) ;
        tt.setText("0.") ;
        bbackspace.setForeground(Color.red) ;

        //注册组件
        b0.addActionListener(this) ;
        b1.addActionListener(this) ;
        b2.addActionListener(this) ;
        b3.addActionListener(this) ;
        b4.addActionListener(this) ;
        b5.addActionListener(this) ;
        b6.addActionListener(this) ;
        b7.addActionListener(this) ;
        b8.addActionListener(this) ;
        b9.addActionListener(this) ;
    }

    public static void main(String args[]) {
        MyCalc f = new MyCalc() ;
        f.setVisible(true) ;
    }

    /**
     * Method actionPerformed
     *
     *
     * @param e
     *
     */
    public void actionPerformed(ActionEvent e) {
        tt.setText(tt.getText() + e.getActionCommand()) ;
    }
}