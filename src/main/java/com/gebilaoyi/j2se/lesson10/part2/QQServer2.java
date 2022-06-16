package com.gebilaoyi.j2se.lesson10.part2;

import com.gebilaoyi.j2se.lesson10.QQServerHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bingyi
 * @date 2022/6/11
 * J2SEStudy
 **/
public class QQServer2 {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("服务端正在监听8888端口...");
            String[] userArray = new String[3];
            Socket[] socketArray = new Socket[3];
             while(true) {
                 Socket s = ss.accept();

                 QQServerHandler2 qsh = new QQServerHandler2(s, userArray, socketArray);
                 Thread t = new Thread(qsh);
                 t.start();
            }
        }catch (Exception ex) {

        }
    }
}
