package com.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private String name;

    public String getName() {
        System.out.println("Name = "+name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String palin(String st){
        System.out.println("-----");
        System.out.println("in palin method "+st);
        System.out.println("---");
        return st;
    }
        
    public void returning(){
        System.out.printf("returning blah ");
       // int i = 10 / 0;
    }

    public void doSomething(){}

    public void throwException(){
        throw new RuntimeException("Demo Exception");
    }
}
