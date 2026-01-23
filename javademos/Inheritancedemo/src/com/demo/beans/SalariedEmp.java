package com.demo.beans;

public class SalariedEmp extends Employee{
    private double sal;
    private double bonus;

    public SalariedEmp(int pid, String pname, String mobile, String dept, String desg, double sal) {
        super(pid, pname, mobile, dept, desg);
        this.sal = sal;
        this.bonus=0.10*sal;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return super.toString()+"SalariedEmp{" +
                "sal=" + sal +
                ", bonus=" + bonus +
                '}';
    }
}
