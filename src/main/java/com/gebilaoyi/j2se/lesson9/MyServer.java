package com.gebilaoyi.j2se.lesson9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bingyi
 * @date 2022/6/9
 * J2SEStudy
 **/
public class MyServer {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(8888) ;
            System.out.println("服务器正在监听：8888端口...");
            while(true) {
                Socket s = ss.accept();
                InputStream is = s.getInputStream();
                InputStreamReader isr = new InputStreamReader(is) ;
                BufferedReader br = new BufferedReader(isr) ;
                String receiveMsg = br.readLine();
                if(receiveMsg != null) {
                    System.out.println(receiveMsg);

                    OutputStream os = s.getOutputStream() ;
                    PrintWriter pw = new PrintWriter(os, true) ;
                    pw.println("hello, i'm server");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
