/*
Generics, Arrays and Containers

Create a generic, singly linked list class called SList, which, to keep things simple, does not implement the List interface.

Each Link object in the list should contain a reference to the next element in the list, but not the previous one (LinkedList, in contrast, is a doubly linked list, which means it maintains links in both directions).

Create your own SListIterator which, again for simplicity, does not implement ListIterator. The only method in SList other than toString( ) should be iterator( ), which produces an SListIterator.

The only way to insert and remove elements from an SList is through SListIterator. Write code to demonstrate SList.
 */
package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> SList = new LinkedList<String>();

        for (int counter = 1; counter < 10; counter++) {
            SList.add("string"+counter);//add's values
        }
        System.out.println("Elements in linked list " + SList); //prints linked list

        SList.remove("string1");//removes string1 from list1
        SList.remove(3);//removes value at index 3
        SList.removeFirst();//removes first
        SList.removeLast();//removes last
        Iterator SListIterator = SList.iterator();//iterator


      while (SListIterator.hasNext()) {
            System.out.print(SListIterator.next()+" ");
        }
    }
}
