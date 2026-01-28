package com.demo.config;

import com.demo.beans.Address;
import com.demo.beans.MyUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.demo")
@PropertySource("classpath:application.properties")
public class AppConfig {

    //@Bean  /// id is same as method name
    @Bean("address")
    public Address getAddress(@Value("${address.street}")String street, @Value("${address.city}")String city, @Value("${address.state}") String state, @Value("${address.zip}")String zip) {
        System.out.println("in getAddress bean method");
        //return new Address(street, city, state, zip);
        Address addr=new Address();
        addr.setStreet(street);
        addr.setCity(city);
        addr.setState(state);
        addr.setZipCode(zip);
        return addr;

    }

    //@Bean
    @Bean("u1")
    public MyUser getMyUser(@Value("${user.uid}")int uid, @Value("${user.uname}")String uname, Address address) {
        System.out.println("in getMyUser bean method");
        return new MyUser(uid, uname,  address);
    }
}
