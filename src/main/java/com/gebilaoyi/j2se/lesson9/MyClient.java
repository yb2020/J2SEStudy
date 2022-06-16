package com.gebilaoyi.j2se.lesson9;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author bingyi
 * @date 2022/6/9
 * J2SEStudy
 **/
public class MyClient {
    public static void main(String args[]) {
        try {
            Socket cs = new Socket("127.0.0.1", 8888);
            OutputStream os = cs.getOutputStream() ;
            PrintWriter pw = new PrintWriter(os, true) ;
            pw.println("hi, i'm jack");

            InputStream is = cs.getInputStream();
            InputStreamReader isr = new InputStreamReader(is) ;
            BufferedReader br = new BufferedReader(isr) ;
            System.out.println(br.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
