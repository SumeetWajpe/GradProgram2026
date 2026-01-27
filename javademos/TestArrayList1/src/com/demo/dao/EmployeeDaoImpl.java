package com.demo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.demo.beans.ContractEmp;
import com.demo.beans.Employee;
import com.demo.beans.Person;
import com.demo.beans.SalariedEmp;
import com.demo.comparators.MyIdComparator;
import com.demo.comparators.MyNameComparator;
import com.demo.comparators.MySalComparator;
import com.demo.exceptions.EmployeeNotFound;

public class EmployeeDaoImpl implements EmployeeDao{
	static List<Employee> elist;
	static {
        elist=new ArrayList<>();
        elist.add(new SalariedEmp(12,"Rajan","444444","gaming","Manager",56789));
        elist.add(new ContractEmp(13,"Rajan","444444","gaming","Manager",6789,50));
        elist.add(new ContractEmp(14,"Ashu","55555","UX","designer",6789,67));
        elist.add(new SalariedEmp(15,"Ramesh","444444","gaming","Analyst",56789));
    }

	@Override
	//adding employee object at the end of ArrayList
	public void save(Employee emp) {
		elist.add(emp);
		
	}

	@Override
	public List<Employee> findAll() {
		return elist;
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFound {
      int pos= elist.indexOf(new Person(id)) ;
      if(pos!=-1){
          return elist.get(pos);
      }
      throw new EmployeeNotFound("Employee not found "+id);
        //int pos=elist.indexOf(new Employee(id));
//		if(pos!=-1) {
//			return elist.get(pos);
//		}
//		throw new EmployeeNotFound("EmployeeNot found---> "+id);
	}

	@Override
	public List<Employee> findByName(String nm) {
//		List<Employee> lst=new ArrayList<>();
//		for(Employee e:elist) {
//			if(e.getPname().equals(nm)) {
//				lst.add(e);
//			}
//		}
		List<Employee> lst=elist.stream()
				.filter(e->e.getPname().equals(nm)) // && e.getDept().equals("HR"))
				.collect(Collectors.toList());
		if(lst.size()>0) {
			return lst;
		}
		return null;
	}

	@Override
	public boolean removeById(int id) {
		//removeif will delete all objects which satisfies the given condition  and
		//remove delete only first matching object
		//elist.removeIf(emp->emp.getsal()>sal);
//        if(elist.remove(new Person(id))){
//            return true;
//        }else{
//            throw new employeeNoteFound("message");
//        }
		return elist.remove(new Person(id));
	}

	@Override
	public List<Employee> sortBySal() {
		List<Employee> newList=(List<Employee>) ((ArrayList)elist).clone();
        Comparator<Person> c=(o1,o2)->{
            double s1,s2;
            if((o1 instanceof SalariedEmp))
                s1=((SalariedEmp) o1).getSal();
            else
                s1=((ContractEmp)o1).getCharges();

            if((o2 instanceof SalariedEmp))
                s2=((SalariedEmp) o2).getSal();
            else
                s2=((ContractEmp)o2).getCharges();
            System.out.println("in salary comparator "+ s1+"----->"+s2);
            return (int)(s1-s2);
        };
		newList.sort(c);
		//Collections.sort(newList);
		//return newList;
        return null;
	}

	@Override
	public List<Employee> sortById() {

List<Employee> newList=(List<Employee>) ((ArrayList)elist).clone();
//		Comparator<Employee> c=(o1,o2)->
//		{if(o1.getPid()<o2.getPid())
//			     return -1;
//		else if(o1.getPid()==o2.getPid())
//			return 0;
//		else return 1;
//
//		};
       newList.sort(null);
//		//newList.sort(new MyIdComparator());
       return newList;
	}

	@Override
	public List<Employee> sortByName() {
		List<Employee> newList=(List<Employee>) ((ArrayList)elist).clone();
		Comparator<Employee> c=(o1,o2)-> {return o1.getPname().compareTo(o2.getPname());};
		newList.sort(c);
		//newList.sort(new MyNameComparator());
		return newList;
		
	}

    @Override
    public void updateEmployee(int id, double sal) throws EmployeeNotFound {
        Employee e=findById(id);
        if(e!=null) {
            if (e instanceof SalariedEmp) {
                ((SalariedEmp) e).setSal(sal);
            } else if (e instanceof ContractEmp) {
                ((ContractEmp) e).setCharges(sal);
            }
        }else{
            throw new EmployeeNotFound("Employee id not found for updation "+id);
        }
    }

}
