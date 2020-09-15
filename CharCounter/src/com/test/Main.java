package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        HashMap<Character, Integer> numCharacters = new HashMap<>();
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 26; i++) {
            numCharacters.put((char) ('a' + i), 0);
            numCharacters.put((char) ('A' + i), 0);
        }

        System.out.println("Please enter a sentence.");
        String sentence = input.nextLine();

        for (Character c : sentence.toCharArray()) {
            if (numCharacters.containsKey(c)) {
                numCharacters.put(c, numCharacters.get(c) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : numCharacters.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
