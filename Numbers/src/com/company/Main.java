package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        String numAsWord, numAsDigit = "";

        System.out.println("Enter numbers as words");
        numAsWord = sn.nextLine();
        String[] words = numAsWord.split(" ");
        String[] possibleWords = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (String word: words){
            for(int i = 0; i < possibleWords.length; i ++){
                if(word.equals(possibleWords[i])){
                    numAsDigit = numAsDigit.concat(Integer.toString(i));
                }
            }
        }
        System.out.println("The number is: "+ Integer.parseInt(numAsDigit));
    }
}
