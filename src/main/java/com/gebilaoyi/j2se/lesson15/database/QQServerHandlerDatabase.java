package com.gebilaoyi.j2se.lesson15.database;

import java.io.*;
import java.net.Socket;
import java.sql.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author bingyi
 * @date 2022/6/11
 * J2SEStudy
 **/
public class QQServerHandlerDatabase implements Runnable {
    Socket s;
    String splitLabel = "#split#" ;
    HashMap<String, Socket> map;

    QQServerHandlerDatabase(Socket s, HashMap<String, Socket> map) {
        this.s = s;
        this.map = map ;
    }
    @Override
    public void run() {
        try {
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is) ;
            BufferedReader br = new BufferedReader(isr);
            String res = br.readLine();
            System.out.println(res);

            if(res != null) {
                String[] resArray = res.split(splitLabel) ;
                switch (resArray[0]) {
                    case "UserLogin":
                        boolean isLogon = false;
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver") ;
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root") ;
                            PreparedStatement statement = connection.prepareStatement("select * from user where username=? and password=?") ;
                            statement.setString(1, resArray[1]);
                            statement.setString(2, resArray[2]);
                            ResultSet rs = statement.executeQuery() ;
                            isLogon = rs.next();
                        }catch (Exception ex) {
                            ex.printStackTrace();
                        }

                        if (isLogon) {
                            OutputStream os = s.getOutputStream();
                            PrintWriter pw = new PrintWriter(os, true) ;
                            pw.println("loginOK");

                            Thread.sleep(100);


                            //把所有 人推给我
                            for(String o : map.keySet()) {
                                pw.println("UserOnline" + splitLabel + o);
                            }

                            //把我推送出去
                            for(Socket o : map.values()) {
                                OutputStream osPushMe = s.getOutputStream();
                                PrintWriter pwPushMe = new PrintWriter(osPushMe, true) ;
                                pwPushMe.println("UserOnline" + splitLabel + resArray[1]);
                            }

                            //把我加入存储
                            map.put(resArray[1], s) ;

                            while(true) {
                                String messageTmp = br.readLine();
                                String[] messageArray = messageTmp.split(splitLabel) ;
                                if(messageArray[0].equals("All")) {
                                    for(Socket o : map.values()) {
                                        OutputStream osPushMe = s.getOutputStream();
                                        PrintWriter pwPushMe = new PrintWriter(osPushMe, true) ;
                                        pwPushMe.println("UserMessage" + splitLabel + messageArray[1] + "对所有人说：" + messageArray[2]);
                                    }
                                }else {
                                    Socket s = map.get(messageArray[0]) ;
                                    if(s != null) {
                                        OutputStream osPushMe = s.getOutputStream();
                                        PrintWriter pwPushMe = new PrintWriter(osPushMe, true) ;
                                        pwPushMe.println("UserMessage" + splitLabel + messageArray[1] + "对"+messageArray[0]+"说：" + messageArray[2]);
                                    }
                                }
                            }

                        }
                        break ;
                }
            }
        }catch (Exception ex) {

        }
    }
}
