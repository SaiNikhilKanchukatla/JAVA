package com.company;

public class TriCycle extends Cycle implements Cycles4{
   TriCycle(){
       System.out.println("This is Tricycle");
   }

    @Override
    public void code() {
    factory();
    }

    @Override
    public void factory() {
        System.out.println("This is Tricycle factory");
    }
}
