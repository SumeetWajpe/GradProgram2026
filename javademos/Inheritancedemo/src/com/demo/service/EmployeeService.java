package com.demo.service;

import com.demo.beans.Employee;

import java.util.List;

public interface EmployeeService {
    void addNewEmployee(int ch);

    List<Employee> getAll();
}
