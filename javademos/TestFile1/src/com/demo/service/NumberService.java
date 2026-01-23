package com.demo.service;

public class NumberService {
    public static int factorial(int num){
        int f=1;
        for(int i=1;i<=num;i++){
            f=f*i;
        }
        return f;
    }
    public static void printTable(int num){
        for(int i=1;i<=10;i++){
            System.out.println(num + "*" +i +"="+(num*i));
        }
    }
}
