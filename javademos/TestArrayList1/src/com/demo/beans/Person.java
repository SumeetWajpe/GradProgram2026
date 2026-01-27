package com.demo.beans;

import java.util.Objects;

public class Person implements Comparable<Person> {
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
    public Person (int id){
        //this.pid=id;
       this(id,null,null);  //parametrized constructor
    }
    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        System.out.println("in person equals method "+this.pid+"--->"+person.pid);
        return this.pid == person.pid;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pid);
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

    @Override
    public int compareTo(Person o) {
        System.out.println("in compareto method os Person "+this.pid+"---->"+o.pid);
//        if(this.pid<o.pid) {
//            return -1;
//        }else if (this.pid==o.pid){
//            return 0;
//        }else{
//            return 1;
//        }
        return this.pid-o.pid;
    }
}
