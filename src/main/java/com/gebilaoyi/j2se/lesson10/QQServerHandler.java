package com.gebilaoyi.j2se.lesson10;

import java.io.*;
import java.net.Socket;

/**
 * @author bingyi
 * @date 2022/6/11
 * J2SEStudy
 **/
public class QQServerHandler implements Runnable {
    String[] userArray;
    Socket[] socketArray;
    Socket s;

    QQServerHandler(Socket s, String[] userArray , Socket[] socketArray) {
        this.s = s;
        this.userArray = userArray;
        this.socketArray = socketArray;
    }
    @Override
    public void run() {
        try{
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is) ;
            BufferedReader br = new BufferedReader(isr) ;

            String message = br.readLine();
            String label = "#split#";

            if(message != null) {
                String[] messageArray = message.split(label) ;
                System.out.println(message);

                OutputStream os = s.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);
                switch (messageArray[0]) {
                    case "Login":
                        if(
                                (messageArray[1].equals("laoyi") && messageArray[2].equals("111111"))
                                        || (messageArray[1].equals("laoer") && messageArray[2].equals("111111"))
                                        || (messageArray[1].equals("laosan") && messageArray[2].equals("111111"))
                        ) {
//
//                            [i] = messageArray[1];
//                            socketArray[i] = s;
//                            i ++;
                            pw.println("LoginOK");
                            Thread.sleep(100) ;

                            //把在线所有人发给自己
                            for(int i = 0 ; i < userArray.length; i ++) {
                                if(userArray[i] != null) {
                                    System.out.println(messageArray[1] + ":UserList" + label + userArray[i]);
                                    pw.println("UserList" + label + userArray[i]);
                                }
                            }
                            //把自己发给所有人
                            for(int i = 0 ; i < userArray.length; i ++) {
                                if(userArray[i] != null) {
                                    OutputStream os1 = socketArray[i].getOutputStream();
                                    PrintWriter pw1 = new PrintWriter(os1, true);
                                    pw1.println("UserList" + label + messageArray[1]);
                                }
                            }

                            //把自己加入容器
                            if(messageArray[1].equals("laoyi")) {
                                userArray[0] = "laoyi";
                                socketArray[0] = s;
                            }else if(messageArray[1].equals("laoer")) {
                                userArray[1] = "laoer";
                                socketArray[1] = s;
                            }else if(messageArray[1].equals("laosan")) {
                                userArray[2] = "laosan";
                                socketArray[2] = s;
                            }

                            while (true) {
                                message = br.readLine() ;
                                messageArray = message.split(label) ;
                                String who = messageArray[0];
                                String toWho = messageArray[1];
                                String toMessage = messageArray[2];

                                if(toWho.equals("All")) {
                                    for(int i = 0 ; i < userArray.length; i ++) {
                                        if(userArray[i] != null) {
                                            OutputStream os1 = socketArray[i].getOutputStream();
                                            PrintWriter pw1 = new PrintWriter(os1, true);
                                            pw1.println("CallBackMessage" + label + who + "对所有人说：" + toMessage + "\n");
                                        }
                                    }
                                }else {
                                    for(int i = 0 ; i < userArray.length; i ++) {
                                        if(userArray[i].equals(toWho) && userArray[i] != null) {
                                            OutputStream os1 = socketArray[i].getOutputStream();
                                            PrintWriter pw1 = new PrintWriter(os1, true);
                                            pw1.println("CallBackMessage" + label + who + "对"+toWho+"说：" + toMessage + "\n");
                                        }
                                    }
                                }
                            }

                        }else {
                            pw.println("LoginError");
                        }
                        break;
                }
            }
        }catch(Exception ex){

        }

    }
}
