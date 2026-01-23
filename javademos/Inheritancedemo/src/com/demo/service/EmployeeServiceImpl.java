package com.demo.service;

import com.demo.beans.ContractEmp;
import com.demo.beans.Employee;
import com.demo.beans.SalariedEmp;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;

import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao edao;

    public EmployeeServiceImpl() {
        this.edao = new EmployeeDaoImpl();
    }

    @Override
    public void addNewEmployee(int ch) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter id");
        int pid=sc.nextInt();
        System.out.println("Enter name");
        sc.nextLine();
        String pname=sc.nextLine();
        System.out.println("enter mobile");
        String mob=sc.next();
        System.out.println("enter dept");
        String dept=sc.next();
        System.out.println("enter desg");
        String desg=sc.next();
        Employee s=null;
        if(ch==1){
            System.out.println("enter sal");
            double sal=sc.nextDouble();
            s=new SalariedEmp(pid,pname,mob,dept,desg,sal);
        }else{
            System.out.println("enter charges");
            double charges=sc.nextDouble();
            System.out.println("enter hrs");
            double hrs=sc.nextDouble();
             s=new ContractEmp(pid,pname,mob,dept,desg,charges,hrs);
        }
        edao.save(s);

    }

    @Override
    public List<Employee> getAll() {
        return edao.findAll();
    }
}
