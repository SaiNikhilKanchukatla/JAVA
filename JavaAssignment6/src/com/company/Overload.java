package com.company;

public class Overload {
    private int value;
    Overload(){
        this(10);
        System.out.println("Overloaded constructor without parameters");
    }
    Overload(int value){
        this.value=value;
        System.out.println("Overloaded constructor called with value:"+value);
    }
}
