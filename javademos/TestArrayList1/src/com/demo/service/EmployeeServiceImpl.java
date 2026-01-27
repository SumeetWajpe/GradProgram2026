package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.ContractEmp;
import com.demo.beans.Employee;
import com.demo.beans.SalariedEmp;
import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.exceptions.EmployeeNotFound;
//import com.demo.utility.GenerateDao;

public class EmployeeServiceImpl implements EmployeeService{


	/*public EmployeeServiceImpl() {
		super();
		this.edao = GenerateDao.getDao(1);
	}*/

    //initialize EmployeeDao
    public EmployeeServiceImpl() {
        this.edao = new EmployeeDaoImpl();
    }private EmployeeDao edao;

   // @Override
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

	@Override
	public Employee serachById(int id) throws EmployeeNotFound {
		return edao.findById(id);
	}

	@Override
	public List<Employee> searchByName(String nm) {
		return edao.findByName(nm);
	}

	@Override
	public boolean deleteById(int id) {
		return edao.removeById(id);
	}

	@Override
	public List<Employee> sortBySal() {
		return edao.sortBySal();
	}

	@Override
	public List<Employee> sortById() {
		return edao.sortById();
	}

	@Override
	public List<Employee> sortByName() {
		return edao.sortByName();
	}

    @Override
    public void modifySal(int id, double sal) throws EmployeeNotFound {
        Employee e=edao.findById(id);
        if(e!=null){
            //edao.updateEmployee(e, id,sal);
            edao.updateEmployee( id,sal);
        }else {
            throw new EmployeeNotFound("Employee not found " + id);
        }
    }


}
