package com.turtlesltd.productshopdatabase.student;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    private String streetAddress;
    private String city;
    private String state;
    private String country;
}
