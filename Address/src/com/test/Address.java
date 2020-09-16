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

        checkZipCode(zipCode);
        this.zipCode = zipCode;
    }

    private void checkZipCode(int zipCode) {
        int zipCodeLength = String.valueOf(zipCode).length();
        if (zipCodeLength == 5 || zipCodeLength == 9) {
            throw new InvalidZipCodeException("Zip Code can't be five or nine digit number ");
        }
    }

    @Override
    public String toString() {
        return "street = '" + street + '\'' +
                ", streetNumber = " + streetNumber +
                ", city = '" + city + '\'' +
                ", zipCode = " + zipCode;

    }
}
