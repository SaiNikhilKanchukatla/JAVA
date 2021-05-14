/*
Operators and More:

1. A vampire number v is a number with an even number of digits n, that can be factored into two numbers x and y each with n/2 digits and not both with trailing zeroes, where v contains precisely all the digits from x and from y, in any order. Write a java program to print first 100 vampire numbers.

2. Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.

3. Create a class with a constructor that takes a String argument. During construction, print the argument. Create an array of object references to this class, but don’t actually create objects to assign into the array. When you run the program, notice whether the initialization messages from the constructor calls are printed.

4. Complete the previous exercise by creating objects to attach to the array of references.

 */
package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Task 1");
        VampireNumbers vampireNumbers = new VampireNumbers();
        vampireNumbers.printVampireNumbers();

        System.out.println("Task 2");
        Overload object =new Overload();

        System.out.println("Task 3");
        Check arr[]=new Check[3];
        //If the program is run now there is not message that constructor is called
        for(int i=0;i<3;i++){
            arr[i]=new Check("Message");
        }
    }
}
