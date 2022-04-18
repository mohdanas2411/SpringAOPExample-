package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Logging.class);

        Employee em = context.getBean("employee", Employee.class);
        em.setName("zara");
        em.getName();
        String val = em.palin("anas");
        System.out.printf("in main class = " + val);
        System.out.println();
        em.returning();

        context.getBean(Employee.class).doSomething();
        //  em.throwException();
    }
}
