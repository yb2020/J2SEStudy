package com.gebilaoyi.j2se.lesson13;

public interface MyListInterface {

    public void add(String element);

    public void add(int index, String element);

    public int size();

    public void remove(int index);
    
    public String get(int index);
}
