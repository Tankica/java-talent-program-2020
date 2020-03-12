package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        System.out.println("Enter width, height and depth to calculate volume of the box");

        int width = sn.nextInt();
        int height = sn.nextInt();
        int depth = sn.nextInt();

        Box box = new Box(width, height, depth);
        System.out.println("The volume of the box is: " + box.volume());
    }
}
