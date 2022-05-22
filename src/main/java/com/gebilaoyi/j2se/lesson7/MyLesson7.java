package com.gebilaoyi.j2se.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author bingyi
 * @date 2022/5/21
 * J2SEStudy
 **/
public class MyLesson7 extends JFrame implements ActionListener {
    JTextField displayText = new JTextField();
    String fButton = "";
    int firstNumber = 0 ;
    MyLesson7() {
        this.setSize(300, 200) ;
        this.setResizable(false);
        int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() ;
        int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight() ;
        this.setLocation((width - 350)/2 , (height - 200)/2) ;


        //new了一堆按钮
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
        JButton bAC = new JButton("AC") ;

        //设置布局
        JPanel p_shuzhi = new JPanel() ;
        p_shuzhi.setLayout(new GridLayout(4 , 5 , 2 , 2)) ;
        p_shuzhi.add(b7) ;
        p_shuzhi.add(b8) ;
        p_shuzhi.add(b9) ;
        p_shuzhi.add(bchu) ;
        p_shuzhi.add(bAC) ;

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

        JPanel p_big = new JPanel() ;
        p_big.setLayout(new BorderLayout()) ;
        p_big.add(p_shuzhi , BorderLayout.CENTER) ;

        this.setLayout(new BorderLayout()) ;
        this.add(p_big, BorderLayout.CENTER);
        this.add(displayText , BorderLayout.NORTH) ;

        displayText.setEditable(false) ;
        displayText.setHorizontalAlignment(JTextField.RIGHT) ;
        displayText.setText("0.") ;

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

        bjia.addActionListener(this);
        bjian.addActionListener(this);
        bchen.addActionListener(this);
        bchu.addActionListener(this);
        bdengyu.addActionListener(this);

        bAC.addActionListener(this);
    }
    public static void main(String args[]) {
        MyLesson7 myLesson7 = new MyLesson7();
        myLesson7.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //是否是"AC"键
        if(e.getActionCommand().equals("AC")) {
            fButton = "";
            firstNumber = 0 ;
            displayText.setText("0.");
            return ;
        }
        //类型
        int inputNumber = -1;
        try {
            inputNumber = Integer.parseInt(e.getActionCommand());
        }catch (Exception ex) {
            if(fButton.equals("") && !e.getActionCommand().equals("=")) {
                fButton = e.getActionCommand();
                firstNumber = Integer.parseInt(displayText.getText()) ;
                displayText.setText("");
            }else {
                //开始运算
                if(fButton.equals("+")) {
                    int secondNumber = Integer.parseInt(displayText.getText());
                    displayText.setText((firstNumber + secondNumber) + "");
                }else if(fButton.equals("-")) {
                    int secondNumber = Integer.parseInt(displayText.getText());
                    displayText.setText((firstNumber - secondNumber) + "");
                }else if(fButton.equals("*")) {
                    int secondNumber = Integer.parseInt(displayText.getText());
                    displayText.setText((firstNumber * secondNumber) + "");
                }else if(fButton.equals("/")) {
                    float secondNumber = Float.parseFloat(displayText.getText());
                    float tmpFirstNumber = new Float(firstNumber) ;

                    displayText.setText((tmpFirstNumber / secondNumber) + "");
                }
            }
        }
        if(inputNumber != -1 && inputNumber >= 0 && inputNumber <= 9) {
            if(displayText.getText().equals("0.")) {
                if(inputNumber == 0) {
                    return ;
                }
                displayText.setText("");
            }
            displayText.setText(displayText.getText() + e.getActionCommand());
        }

    }
}
