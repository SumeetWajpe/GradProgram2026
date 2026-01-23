package com.demo.beans;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    static int count;
    static{
        count=0;
    }
    private String pid;
    private String pname;
    private String address;
    private LocalDate bdate;
    //default  constructor
    public Person(){
        System.out.println("in default constructor");
        pid=generateId("xxxxxx");
        pname=null;
        address=null;
        bdate=null;
    }

    public Person(String pname,String address,LocalDate ldt){
        System.out.println("in parametrised constructor");
        count++;
        pid=generateId(pname);;
        this.pname=pname;
        this.address=address;
        bdate=ldt;

    }

    private String generateId(String pname) {
        String nm=pname.substring(0,2);
        count++;
        return nm+count;
    }

    public String getPid() {
        return pid;
    }


    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBdate() {
        return bdate;
    }

    public void setBdate(LocalDate bdate) {
        this.bdate = bdate;
    }

    public String toString(){
        System.out.println("in tostring");
        String str=null;
        if(bdate!=null) {
           str = bdate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        return "Id : "+this.pid+" Name : "+pname +" Address: "+address+" Birthdate: "+str;
    }

}
