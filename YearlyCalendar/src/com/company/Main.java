package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter some year");

        int year = sn.nextInt();
        boolean isLeapYear = checkLeapYear(year);
        String[] dates = isLeapYear ? new String[366] : new String[365];

        int numOfDaysInMonth = 0;
        int arrayElementCounter = 0;
        for(int i = 1; i <= 12; i ++){
            if(i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12){
                numOfDaysInMonth = 31;
            }
            if( i == 2){
                numOfDaysInMonth = isLeapYear ? 29 : 28;
            }else if(i == 4 || i == 6 || i == 9 || i == 11){
                numOfDaysInMonth = 30;
            }
            for(int j = 1; j <= numOfDaysInMonth; j ++){
                if( arrayElementCounter < dates.length) {
                    dates[arrayElementCounter] = year + "-" + i + "-" + j;
                    arrayElementCounter++;
                }
            }
        }
        for (String date : dates){
            System.out.println(date);
        }
    }

    public static boolean checkLeapYear(int year) {
        boolean leap;
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            } else
                leap = true;
        } else
            leap = false;
        return leap;
    }
}
