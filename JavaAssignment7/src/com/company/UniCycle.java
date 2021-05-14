package com.company;

public class UniCycle extends Cycles implements Cycles4{

    @Override
    void balance() {
        System.out.println("Balancing Unicycle");
    }

    @Override
    public void code() {
     factory();
    }

    @Override
    public void factory() {
        System.out.println("This is unicycle  factory");
    }
}
