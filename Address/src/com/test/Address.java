package com.test;

public class Address {
    private String street;
    private int streetNumber;
    private String city;
    private int zipCode;

    public Address(String street, int streetNumber, String city, int zipCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "street = '" + street + '\'' +
                ", streetNumber = " + streetNumber +
                ", city = '" + city + '\'' +
                ", zipCode = " + zipCode;

    }
}
