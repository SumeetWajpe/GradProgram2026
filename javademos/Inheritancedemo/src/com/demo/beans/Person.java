package com.demo.beans;

public class Person {
    private int pid;
    private String pname;
    private String mobile;

    public Person() {
        System.out.println("in default constructor");
        this.pid = 0;
        this.pname=null;
        this.mobile=null;
    }

    public Person(int pid, String pname, String mobile) {
        System.out.println("in parametrised constructor");
        this.pid = pid;
        this.pname = pname;
        this.mobile = mobile;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
