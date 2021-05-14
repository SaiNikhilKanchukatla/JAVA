package com.company;

import java.util.Scanner;
interface First{
    public void A();
    public void B();
}
interface Second{
    public void C();
    public void D();
}
interface Third{
    public void E();
    public void F();

}
interface Fourth extends First,Second,Third{
    public void G();

}
class Prog3 implements Fourth{
    public void A(){
        System.out.println(" A  method");
    }
    public void B(){
        System.out.println(" B  method");
    }
    public void C(){
        System.out.println(" C method");
    }
    public void D(){
        System.out.println(" D method");
    }
    public void E(){
        System.out.println("E method");
    }
    public void F(){
        System.out.println("F method");
    }
    public void G(){
        System.out.println("G  mehtod ");
    }
}

public class Task3 {
     void method1(First f) {
        f.A();
    };
     void method2(Second s) {
        s.C();
    };
     void method3(Third t) {
        t.E();
    };
     void method4(Fourth f) {
        f.G();
    };
}
