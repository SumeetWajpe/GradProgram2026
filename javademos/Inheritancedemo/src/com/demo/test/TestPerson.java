package com.demo.test;

import com.demo.beans.Employee;
import com.demo.service.EmployeeService;
import com.demo.service.EmployeeServiceImpl;

import java.util.List;
import java.util.Scanner;

public class TestPerson {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in) ;
        int choice=0;
        do {
            System.out.println("1. add new Employee\n2. delete employee\n3. update Employee\n 4. display all");
            System.out.println("5. display in sorted order\n6. display by id\n7. calculate bonus\n8. calculate salary\n9.exit");
            System.out.println("choice: ");
            choice=sc.nextInt();
            EmployeeService eservice=new EmployeeServiceImpl();
            switch(choice){
                case 1->{
                    System.out.println("1. Salaried \n 2. Contract \n 3. vendor \n choice:");
                    int ch=sc.nextInt();
                    eservice.addNewEmployee(ch);
                }
                case 2->{}
                case 3->{}
                case 4->{
                    List<Employee> elist=eservice.getAll();
                    /*for(Employee e:elist){
                        System.out.println(e);
                    }*/
                   // elist.forEach(e->System.out.println(e));
                    elist.forEach(System.out::println);

                }
                case 5->{}
                case 6->{}
                case 7->{}
                case 8->{}
                case 9->{
                    System.out.println("Thank you for visiting");
                    System.exit(0);
                }
                default->{
                    System.out.println("wrong choice");
                }
            }

        }while(choice!=9);

    }
}
