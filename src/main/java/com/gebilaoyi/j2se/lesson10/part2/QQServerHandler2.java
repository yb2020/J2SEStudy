package com.gebilaoyi.j2se.lesson10.part2;

import java.io.*;
import java.net.Socket;

/**
 * @author bingyi
 * @date 2022/6/11
 * J2SEStudy
 **/
public class QQServerHandler2 implements Runnable {
    String[] userArray;
    Socket[] socketArray;
    Socket s;
    String splitLabel = "#split#" ;

    QQServerHandler2(Socket s, String[] userArray , Socket[] socketArray) {
        this.s = s;
        this.userArray = userArray;
        this.socketArray = socketArray;
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
                        if(
                                (resArray[1].equals("laoyi") && resArray[2].equals("111111"))
                                        || (resArray[1].equals("laoer") && resArray[2].equals("111111"))
                                        ||(resArray[1].equals("laosan") && resArray[2].equals("111111"))
                        ) {
                            OutputStream os = s.getOutputStream();
                            PrintWriter pw = new PrintWriter(os, true) ;
                            pw.println("loginOK");

                            Thread.sleep(100);

                            //把所有 人推给我
                            for(int i = 0 ; i < userArray.length; i ++) {
                                if(userArray[i] != null) {
                                    pw.println("UserOnline" + splitLabel + userArray[i]);
                                }
                            }

                            //把我推送出去
                            for(int i = 0 ; i < socketArray.length; i ++) {
                                if(socketArray[i] != null) {
                                    OutputStream osPushMe = socketArray[i].getOutputStream();
                                    PrintWriter pwPushMe = new PrintWriter(osPushMe, true) ;
                                    pwPushMe.println("UserOnline" + splitLabel + resArray[1]);
                                }
                            }

                            //把我加入存储
                            if(resArray[1].equals("laoyi")) {
                                userArray[0] = "laoyi";
                                socketArray[0] = s;
                            }else if(resArray[1].equals("laoer")) {
                                userArray[1] = "laoer";
                                socketArray[1] = s;
                            }else if(resArray[1].equals("laosan")) {
                                userArray[2] = "laosan";
                                socketArray[2] = s;
                            }

                            while(true) {
                                String messageTmp = br.readLine();
                                String[] messageArray = messageTmp.split(splitLabel) ;
                                if(messageArray[0].equals("All")) {
                                    for(int i = 0 ; i < socketArray.length; i ++) {
                                        if(socketArray[i] != null) {
                                            OutputStream osPushMe = socketArray[i].getOutputStream();
                                            PrintWriter pwPushMe = new PrintWriter(osPushMe, true) ;
                                            pwPushMe.println("UserMessage" + splitLabel + messageArray[1] + "对所有人说：" + messageArray[2]);
                                        }
                                    }
                                }else {
                                    for(int i = 0 ; i < userArray.length; i ++) {
                                        if(messageArray[0].equals(userArray[i])) {
                                            OutputStream osPushMe = socketArray[i].getOutputStream();
                                            PrintWriter pwPushMe = new PrintWriter(osPushMe, true) ;
                                            pwPushMe.println("UserMessage" + splitLabel + messageArray[1] + "对"+messageArray[0]+"说：" + messageArray[2]);
                                        }
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
