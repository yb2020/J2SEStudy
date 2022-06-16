package com.gebilaoyi.j2se.lesson10;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bingyi
 * @date 2022/6/11
 * J2SEStudy
 **/
public class QQServer {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("服务端正在监听8888端口...");
            String[] userArray = new String[3];
            Socket[] socketArray = new Socket[3];

            while(true) {
                Socket s = ss.accept();

                QQServerHandler qsh = new QQServerHandler(s, userArray, socketArray);
                Thread t = new Thread(qsh);
                t.start();

            }
        }catch (Exception ex) {

        }
    }
}
