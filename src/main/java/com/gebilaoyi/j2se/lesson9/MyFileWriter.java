package com.gebilaoyi.j2se.lesson9;

import java.io.*;

/**
 * @author bingyi
 * @date 2022/6/9
 * J2SEStudy
 **/
public class MyFileWriter {
    public static void main(String args[]) {
        try {
            File f = new File("/Users/bingyi/Desktop/test.txt");
            OutputStream os = new FileOutputStream(f) ;
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw) ;
            bw.write("i'm jack\n");
            bw.write("i'm jack\n");
            bw.write("i'm jack\n");
            bw.write("i'm jack\n");
            bw.write("i'm jack\n");
            bw.close();
        }catch (Exception ex) {

        }
    }
}
