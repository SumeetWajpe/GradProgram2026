package com.demo.beans;

public class ContractEmp extends Employee{
    private double charges;
    private double hrs;
    public ContractEmp(){

    }

    @Override
    public double calculateSal() {
        return hrs*charges;
    }

    public ContractEmp(int pid, String pname, String mobile, String dept, String desg, double charges,double hrs) {
        super(pid, pname, mobile, dept, desg);
        this.charges = charges;
        this.hrs=hrs;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public double getHrs() {
        return hrs;
    }

    public void setHrs(double hrs) {
        this.hrs = hrs;
    }

    @Override
    public String toString() {
        return super.toString()+"ContractEmp{" +
                "charges=" + charges +
                ", hrs=" + hrs +
                '}';
    }
}
