package SaiNikhilKanchukatla.assignment.main;
import SaiNikhilKanchukatla.assignment.data.Defaultinit;
import SaiNikhilKanchukatla.assignment.singleton.Demo;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string :");
        Demo obj = Demo.getObject(sc.next());
        obj.print();
        System.out.println();
        Defaultinit defaultinit = new Defaultinit();
        defaultinit.display();
        defaultinit.methodDefault();
    }
}