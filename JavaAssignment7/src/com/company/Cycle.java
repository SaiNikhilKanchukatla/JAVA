package com.company;

public class Cycle {
    public void run(){
        Cycles[] cycle =new Cycles[3];
        cycle[0]= new UniCycle();
        cycle[0].balance();
        cycle[1]=new BiCycle();
        cycle[1].balance();
        //cycle[2]=new TriCycle(); //Gives error
        //cycle[2].balance();//there is no balance in tricycle
        System.out.println("Task 4");
        Cycles4[] cycles4 = new Cycles4[3];
        cycles4[0]=new UniCycle();
        cycles4[0].code();
        cycles4[1]=new BiCycle();
        cycles4[1].code();
        cycles4[2]=new TriCycle();
        cycles4[2].code();
    }
}
