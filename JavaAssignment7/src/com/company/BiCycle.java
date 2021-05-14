package com.company;

public class BiCycle extends Cycles  implements Cycles4{
    @Override
    void balance() {
        System.out.println("Balancing Bicycle");
    }

    @Override
    public void code() {
   factory();
    }

    @Override
    public void factory() {
        System.out.println("This is Bicycle factory");
    }
}
