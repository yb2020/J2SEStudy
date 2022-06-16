package com.gebilaoyi.j2se.lesson8;

import java.io.*;

/**
 * @author bingyi
 * @date 2022/5/29
 * J2SEStudy
 **/
public class MyCopy {
    public static void main(String args[]) {
        File f = new File("/Users/bingyi/Desktop/meeting_02.mp4") ;
        File copyToFile = new File("/Users/bingyi/Desktop/111.mp4") ;

        try {
            InputStream is = new FileInputStream(f);
            OutputStream os = new FileOutputStream(copyToFile);
            byte[] buffer = new byte[1024] ;
            int length = is.available() ;
            int count = length / 1024 + 1 ;
            for(int i = 0 ; i < count; i++) {
                int readPosition = is.read(buffer) ;
                os.write(buffer, 0, readPosition);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
