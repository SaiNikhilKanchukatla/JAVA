package SaiNikhilKanchukatla.assignment.data;

public class Defaultinit {
    int number;
    char letter;
    public void methodDefault(){
        int a,b;//local variables not intialised so it shows compile time error
       // System.out.println(a+" "+b);
    }
    public void display(){
        System.out.println("Default values of int and char:");
        System.out.print(number+" "+letter);
    }
}
