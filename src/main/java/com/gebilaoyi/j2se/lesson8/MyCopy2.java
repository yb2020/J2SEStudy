package com.gebilaoyi.j2se.lesson8;

import java.io.*;

/**
 * @author bingyi
 * @date 2022/5/29
 * J2SEStudy
 **/
public class MyCopy2 {
    public static void main(String args[]) {
        File f = new File("/Users/bingyi/Desktop/绘本 3") ;
        File copyToFile = new File("/Users/bingyi/Desktop/绘本 3_复制") ;
        copyToFile.mkdir();
        File[] listFiles = f.listFiles() ;

        for(File tmp : listFiles) {
            copy(tmp, copyToFile);
        }


    }

    public static void copy(File sourceFile, File targetFile) {
        String fileName = targetFile.getAbsolutePath() + "/" + sourceFile.getName();
        File realCopyFile = new File(fileName) ;

        if(sourceFile.isDirectory()) {
            realCopyFile.mkdir();
            File[] listFiles = sourceFile.listFiles();
            for(File tmp : listFiles) {
                copy(tmp, realCopyFile);
            }
        }else {
            try {
                InputStream is = new FileInputStream(sourceFile);
                OutputStream os = new FileOutputStream(realCopyFile);
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
}
