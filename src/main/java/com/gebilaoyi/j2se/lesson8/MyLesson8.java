package com.gebilaoyi.j2se.lesson8;

import java.io.*;

/**
 * @author bingyi
 * @date 2022/5/29
 * J2SEStudy
 **/
public class MyLesson8 {
    public static void main(String args[]) {
        File f = new File("/Users/bingyi/Desktop/WechatIMG2735.png") ;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fr) ;
            while (bufferedReader.ready()) {
                System.out.println(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
