package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String date, month, day, year;

        System.out.println("Enter a date in format MM/DD/YYYY");
        date = sn.nextLine();

        if(date.length() == 10){
            month = date.substring(0,2);
            day = date.substring(3,5);
            year = date.substring(6,10);
            System.out.println("Month is: " + month + "\nDay is: " + day + "\nYear is: " + year);
        }else {
            System.out.println("Invalid format");
        }
    }
}
