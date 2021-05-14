/*
Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
Write time and space complexity of your solution as comments in the source file.
 */
package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String:");
        String input= scanner.next();
        input=input.toLowerCase(); 
        hasAllAlphabets(input);
    }
//Time complexity O(n) and Space Complexity O(n)
    private static void hasAllAlphabets(String input) {
        HashSet<Character> set = new HashSet();//set contains only unique values
        for(char temp:input.toCharArray()){
            if(temp>='a' && temp<='z')
                set.add(temp);
        }
        if(set.size()==26) // so if set contains 26 elements then all 26 alphabets are present
            System.out.println("Has all alphabets");
        else
            System.out.println("Not contains all alphabets");
    }
}
