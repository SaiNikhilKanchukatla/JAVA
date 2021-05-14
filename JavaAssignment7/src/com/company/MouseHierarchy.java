package com.company;

public class MouseHierarchy {
    public void run(){
        Rodent[] rodents =new Rodent[3];
        rodents[0]=new Mouse();
        rodents[0].show();
        rodents[1]=new Gerbil();
        rodents[1].show();
        rodents[2]= new Hamster();
        rodents[2].show();
    }
}
