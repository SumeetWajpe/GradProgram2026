package com.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("user1")
//@Component
public class MyUser {
    private int uid;
    private String uname;
   // @Autowired
    private Address addr;

    public MyUser() {
        System.out.println("in user default constructor");
    }

    public MyUser(@Value("101") int uid, @Value("John Doe") String uname, Address addr) {
        this.uid = uid;
        this.uname = uname;
        this.addr = addr;
    }

    public int getUid() {
        return uid;
    }
    //@Value("${user.uid:0}")
    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }
    //@Value("${user.uname:DefaultUser}")
    public void setUname(String uname) {
        this.uname = uname;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", addr=" + addr +
                '}';
    }
}
