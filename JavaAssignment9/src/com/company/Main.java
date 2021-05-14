/*
String and Type Information

Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.

 */
package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Line:");
        String input = sc.nextLine();
        String regex = "^[A-Z][A-Za-z0-9_!@#\\$%\\^\\&*\\)\\(+=.\\s+]*[.]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            System.out.println("Match found");
        }
        else{
            System.out.println("Match not found");
        }
    }
}
