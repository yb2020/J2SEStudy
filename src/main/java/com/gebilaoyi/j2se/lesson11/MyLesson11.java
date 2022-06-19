package com.gebilaoyi.j2se.lesson11;

/**
 * @author bingyi
 * @date 2022/6/19
 * J2SEStudy
 **/
public class MyLesson11 {
    public static void main(String args[]) {
        int[] array = new int[100] ;
        for(int i = 0; i < array.length;) {
            int num = (int) (Math.random() * 200);
            boolean bool = false ;
            for(int j = 0 ; j < i; j ++) {
                if(array[i] == array[j]) {
                    bool = true;
                    break;
                }
            }
            if(!bool) {
                array[i] = num ;
                i ++;
            }
        }

        int[] bubbleArray = new int[100] ;
        int[] choiceArray = new int[100] ;
        for(int i = 0 ; i < array.length; i ++) {
            bubbleArray[i] = array[i] ;
            choiceArray[i] = array[i] ;
            System.out.print(array[i] + "  ");
        }
        System.out.println();


        //冒泡排序
        int tmp ;
        for(int i = 0 ; i < bubbleArray.length; i ++) {
            for(int j = 0 ; j < bubbleArray.length; j ++ ) {
                if(bubbleArray[i] < bubbleArray[j]) {
                    tmp = bubbleArray[i] ;
                    bubbleArray[i] = bubbleArray[j] ;
                    bubbleArray[j] = tmp ;
                }
            }
        }
        for(int i = 0 ; i < bubbleArray.length; i ++) {
            System.out.print(bubbleArray[i] + "  ");
        }

        System.out.println();

        //选择排序
        for(int i = 0 ; i < choiceArray.length; i ++) {
            int index = i;
            for(int j = i ; j < choiceArray.length; j ++) {
                if(choiceArray[j] < choiceArray[index]) {
                    index = j ;
                }
            }
            int tmpNum = choiceArray[i];
            choiceArray[i] = choiceArray[index];
            choiceArray[index] = tmpNum ;
        }

        for(int i = 0 ; i < choiceArray.length; i ++) {
            System.out.print(choiceArray[i] + "  ");
        }
    }
}
