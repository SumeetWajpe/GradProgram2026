package com.demo.dao;

import com.demo.beans.Employee;

import java.util.List;

public interface EmployeeDao {
    void save(Employee s);

    List<Employee> findAll();
}
