package com.company;
/*
Create a java program to search through the home directory and look for files that match a regular expression.
The program should be able to take inputs repeatedly and should print out the full absolute path of the matching files found.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

class FileSearcher{

    public void findFile(String path,String fileType) {
        File directory = new File(path);
        File files[] = directory.listFiles();
        if (files != null && files.length > 0) {
            for (File temp:files) {//Iterating over the folder and files
                if (temp.isDirectory()) {
                    findFile(temp.getAbsolutePath(), fileType);//if folder we call for folder to search files in it
                } else {
                    if (temp.getName().endsWith("."+ fileType)) {//checking for extension to match
                        System.out.println("File exists at" + temp.getAbsolutePath());
                    }
                }
            }
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the file type :");//Regular expression : We take type of files required from client
        String fileType = br.readLine();
        FileSearcher fileSearcher = new FileSearcher();
        try {
            fileSearcher.findFile("/home", fileType);
        }
        catch (Exception exception){
            System.out.println("Files not found");
        }
    }
}
