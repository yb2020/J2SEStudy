package com.gebilaoyi.j2se.lesson15.database;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author bingyi
 * @date 2022/6/11
 * J2SEStudy
 **/
public class QQServerDatabase {
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("QQ Database服务端正在监听8888端口...");
            HashMap<String, Socket> storageMap = new HashMap<>() ;
            while(true) {
                 Socket s = ss.accept();

                 QQServerHandlerDatabase qsh = new QQServerHandlerDatabase(s, storageMap);
                 Thread t = new Thread(qsh);
                 t.start();
            }
        }catch (Exception ex) {

        }
    }
}
