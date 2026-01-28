package com.demo.test;

import com.demo.beans.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestHello {
    public static void main(String[] args) {
       /* HelloWorld hw1=new HelloWorld();
        hw1.setMsg("xxxxxx");
        HelloWorld hw=new HelloWorld("greeting");*/
        ApplicationContext ctx=new ClassPathXmlApplicationContext("springconfig.xml");
        HelloWorld myhw=(HelloWorld) ctx.getBean("hw");
        System.out.println(myhw.sayHello());
        System.out.println(myhw.getMsg());

        HelloWorld myhw1=(HelloWorld) ctx.getBean("hw1");
        System.out.println(myhw1.sayHello());
        System.out.println(myhw1.getMsg());
    }
}
