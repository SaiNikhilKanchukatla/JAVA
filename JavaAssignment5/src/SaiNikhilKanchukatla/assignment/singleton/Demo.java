package SaiNikhilKanchukatla.assignment.singleton;

public class Demo {
    String varible;
    static Demo object =new Demo();
    public static Demo getObject(String s){
        object.varible =s;
        return object;
    }
    public void print(){
        System.out.print(varible);
    }

}
