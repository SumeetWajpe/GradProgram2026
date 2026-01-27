package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;
import com.demo.exceptions.EmployeeNotFound;

public interface EmployeeDao {

	void save(Employee employee);

	List<Employee> findAll();

	Employee findById(int id) throws EmployeeNotFound;

	List<Employee> findByName(String nm);

	boolean removeById(int id);

	List<Employee> sortBySal();

	List<Employee> sortById();

	List<Employee> sortByName();

    void updateEmployee(int id, double sal) throws EmployeeNotFound;
}
