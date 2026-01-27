package com.demo.dao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.demo.beans.Employee;
import com.demo.exceptions.EmployeeNotFound;
import com.sun.net.httpserver.Filter;

public class EmployeeSetDaoImpl implements EmployeeDao{
    public static Set<Employee> hset;
    static {
    	hset=new HashSet<>();
    	
    }
	@Override
	public void save(Employee employee) {
		//ToDo 1:add Employee object to HashSet
		
	}

	@Override
	public Set<Employee> findAll() {

        //ToDo 2: return the set
        return null;
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFound {
		//ToDo 3:   use for loop to search the Employee by id

        //this is Java 1.8 to replace for loop with stream functions
	   /* Optional<Employee> emp1=hset.stream().filter(emp->emp.getEmpid()==id).findFirst();
	    if(emp1.isPresent())
	         return emp1.get();*/
		return null;
	}

	@Override
	public List<Employee> findByName(String nm) {
		//ToDo 4: create a ArrayList and Search by name using for loop
        // add objects to ArrayList which matches the nm

        //this is java 1.8 stream functions to do the same
	    //List<Employee> elist=hset.stream()
		                  //   .filter(emp->emp.getEname().equals(nm))
		                  //   .collect(Collectors.toList());
// uncomment the code to check the size
//	    if(elist.size()>0)
//			return elist;
		return null;
	}

	@Override
	public boolean removeById(int id) {
		//use remove method of SetClass
		return false;
	}

	@Override
	public Set<Employee> sortBySal() {
		//ToDo 5 create a Comparator to sort it based on sal and pass it to TreeSet

        //When you add objects to TreeSet. It arranges it in sorted order
        //based on Comparator you are using

        //uncomment the code Once yopu create comparator c
//		Set<Employee> eset=new TreeSet<>(c);
//		for(Employee e:hset) {
//			eset.add(e);
//		}
//		return eset;
        //comment this code
        return null;
	}

	@Override
	public Set<Employee> sortById() {
		// ToDo 6 add Comparable inetrface to Employee Class
        //create a TreeSet and
        //add all Objects from HashSet To TreeSet
        return null;
	}

	@Override
	public Set<Employee> sortByName() {
		//ToDo 7 sort the Set by name and return it
        //Note: USe Comparator
        return null;
	}

}
