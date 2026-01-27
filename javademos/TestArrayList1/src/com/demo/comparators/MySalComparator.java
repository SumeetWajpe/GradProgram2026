package com.demo.comparators;

import com.demo.beans.ContractEmp;
import com.demo.beans.Person;
import com.demo.beans.SalariedEmp;

import java.util.Comparator;

public class MySalComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {

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
    }

}
