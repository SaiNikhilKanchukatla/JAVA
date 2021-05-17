package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        int testcases=scanner.nextInt();
        while(testcases>0){
            String signupdate=scanner.next();
            String currentdate= scanner.next();
            Date signUp =new SimpleDateFormat("dd-MM-yyyy").parse(signupdate); //converting string to date
            Date currentDate=new SimpleDateFormat("dd-MM-yyyy").parse(currentdate); //converting string to date
            if(currentDate.getYear()==signUp.getYear()){
                System.out.println("No range");
            }
            else{
                Calendar calendar = new GregorianCalendar();
                calendar=Calendar.getInstance();
                calendar.setTime(signUp);
                calendar.add(Calendar.DATE , 30);//adding 30 days
                Date afterThirty=calendar.getTime();//after 30 days
                calendar.add(Calendar.DATE,-60);//subracting 30 days
                Date beforeThirty=calendar.getTime();//before 30 days

                ////printing the range in format
                System.out.print((beforeThirty.getDate())+"-");
                System.out.print(beforeThirty.getMonth()+1+"-");
                System.out.print(currentDate.getYear()+1900+" ");
                ///printing answer range
                int m=afterThirty.getMonth()+1;
                int y= currentDate.getYear()+1900;
                int d=afterThirty.getDate()+1;
                Date date = new SimpleDateFormat("dd-MM-yyyy").parse(d+"-"+m+"-"+y);
                if(date.after(currentDate))//checking for backdate
                    System.out.println(currentdate);
                else
                    System.out.println(d+"-"+m+"-"+y);

            }
            testcases--;
        }
    }
}

