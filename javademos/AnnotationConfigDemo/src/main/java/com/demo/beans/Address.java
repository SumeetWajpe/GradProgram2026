package com.demo.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("addr1")
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    public Address() {
        super();
        System.out.println("in address default constructor");
    }
    public Address(String street, String city, String state, String zipCode) {
        super();
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

   // @Value("${address.street:333, MG Road}")
    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }
    //@Value("${address.city:Mumbai}")
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    @Value("${address.city")
    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }
    @Value("${address.zip}")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
