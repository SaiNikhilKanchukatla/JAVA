package com.company;

public class Task5 {
    public void run() {
        SecondClass secondClass =new SecondClass(10);
    }

    class Innerclass{
        private int value;
        Innerclass(int value){
            this.value=value;
            System.out.println(value);
        }
    }
    class SecondClass extends Innerclass{
        SecondClass(int value){
            super(value);
        }
    }

}
