package com.demo.test;

import com.demo.beans.Address;
import com.demo.beans.MyUser;
import com.demo.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        MyUser u1=(MyUser)ctx.getBean("u1");
        System.out.println(u1);

        Address a1=(Address)ctx.getBean("address");
        System.out.println(a1);

    }
}
