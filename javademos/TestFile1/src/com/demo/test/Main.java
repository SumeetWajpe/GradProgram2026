package com.demo.test;

import com.demo.service.*;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choice=0;
       do {
            System.out.println("1. factorial \n 2. printTable \n 3.exit");
            choice=sc.nextInt();
            switch(choice){
                case 1->{
                    System.out.println("enter number");
                    int n=sc.nextInt();
                    int ans= NumberService.factorial(n);
                    System.out.println("factorial : "+ans);
                }

                case 2->{
                    System.out.println("enter number");
                    int n=sc.nextInt();
                     NumberService.printTable(n);

                }

                case 3 ->{
                    System.out.println("Thank you for visiting........");
                    //System.exit(0);
                }
                default->{
                    System.out.println("wrong choice");
                }
            }
        }while(choice!=3);



    }
}