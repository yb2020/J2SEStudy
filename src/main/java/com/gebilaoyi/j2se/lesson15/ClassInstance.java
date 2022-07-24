package com.gebilaoyi.j2se.lesson15;

/**
 * @author bingyi
 * @date 2022/7/24
 * J2SEStudy
 **/
public class ClassInstance {
    public static void main(String[] args) {
        Integer i = 0 ;
        //上塑造型
        Object j = i ;
        //下塑造型
//        String k = (String)j ;
//        String k = "" + j ;
        String k = String.valueOf(j) ;
    }
}
