package com.demo.dao;

import com.demo.beans.ContractEmp;
import com.demo.beans.Employee;
import com.demo.beans.SalariedEmp;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{
    static List<Employee> elist;
    static{
        elist=new ArrayList<>();
        elist.add(new SalariedEmp(12,"Rajan","444444","gaming","Manager",56789));
        elist.add(new ContractEmp(12,"Rajan","444444","gaming","Manager",6789,50));
        elist.add(new ContractEmp(14,"Ashu","55555","UX","designer",6789,67));
        elist.add(new SalariedEmp(12,"Rajan","444444","gaming","Analyst",56789));
    }

    @Override
    public void save(Employee s) {
            elist.add(s);
    }

    @Override
    public List<Employee> findAll() {
        return elist;
    }
}
