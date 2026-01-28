package com.demo.beans;

public class HelloWorld {
    private String msg;
    public HelloWorld(){
        System.out.println("Hello World default constructor");
    }

    public HelloWorld(String msg) {
        System.out.println("in parametrised constructor");
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        System.out.println("in setter of msg");
        this.msg = msg;
    }

    public String sayHello(){
        return "Hello World!!";
    }

    @Override
    public String toString() {
        return "HelloWorld{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
