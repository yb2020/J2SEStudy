package com.gebilaoyi.j2se.lesson13;

/**
 * @author bingyi
 * @date 2022/7/5
 * J2SEStudy
 **/
public class MyArraylist implements MyListInterface {
    private int length = 100;
    private String[] textArray ;
    private int position = 0;

    MyArraylist() {
        textArray = new String[length] ;
    }
    MyArraylist(int length) {
        this.length = length;
        textArray = new String[this.length] ;
    }
    @Override
    public void add(String element) {
        textArray[position] = element;
        position ++;
    }

    @Override
    public void add(int index, String element) {
        for(int i = position; i >= index; i--) {
            textArray[i + 1] = textArray[i];
        }
        textArray[index] = element;
        position ++;
    }

    @Override
    public int size() {
        return position;
    }

    @Override
    public void remove(int index) {
        textArray[index] = "";
        for(int i = index; i < position - 1; i++) {
            textArray[i] = textArray[i + 1];
        }
        position -- ;
    }

    @Override
    public String get(int index) {
        if(index > position) {
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        return textArray[index];
    }
}
