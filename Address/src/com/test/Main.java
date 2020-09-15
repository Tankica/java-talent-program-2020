package com.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Address address;

        System.out.println("For your address you need to enter following information each separated with comma: street, street number, city, zip code");
        String userAddress = input.nextLine();
        String[] addressFields = userAddress.split(",");

        int zipCode = Integer.parseInt(addressFields[3]);
        int zipCodeLength = String.valueOf(zipCode).length();
        if (zipCodeLength == 5 || zipCodeLength == 9) {
            throw new InvalidZipCodeException("Zip Code can't be five or nine digit number ");
        } else {
            address = new Address(addressFields[0], Integer.parseInt(addressFields[1]), addressFields[2], zipCode);
        }

        System.out.println("You have enter the following address: " + address.toString());
    }
}
