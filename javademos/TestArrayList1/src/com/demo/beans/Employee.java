package com.demo.beans;

abstract public class Employee extends Person {
    private String dept;
    private String desg;
    public Employee(){

    }
    public Employee(int pid, String pname, String mobile,String dept, String desg) {
        super(pid,pname,mobile); //call parametrised constructor of parent
        System.out.println("in parametrised constructor");
        this.dept = dept;
        this.desg = desg;
    }
    public Employee(int id){
        super(id);
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }
    abstract public double calculateSal();
    @Override
    public String toString() {

        return super.toString()+"Employee{" +
                "dept='" + dept + '\'' +
                ", desg='" + desg + '\'' +
                '}';
    }
}
