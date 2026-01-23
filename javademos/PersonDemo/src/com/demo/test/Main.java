package com.demo.test;

import com.demo.beans.Person;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
         Person p=new Person("Kishori","Baner", LocalDate.of(2000,04,27));
        System.out.println(p);
        p.setAddress("Aundh");
        Person p1=new Person("Rajan","Baner", LocalDate.of(2000,04,27));
        System.out.println(p1);
        Person p3=new Person();
        System.out.println(p3);
    }
}