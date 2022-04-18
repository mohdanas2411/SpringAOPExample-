package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Aspect
@ComponentScan("com.spring.aop")
@Configuration
@EnableAspectJAutoProxy
public class Logging {


    @Pointcut("execution(* com.spring.aop.*.*(..))")
    private void selectAll(){}

    //@Pointcut("execution(* com.test.Employee.*(..))")
    @Pointcut("execution(* com.spring.aop.Employee.*(..))")
    private void throwAndReturn(){}

    @Pointcut("bean()")
    private void beanDesignator(){}


    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("Going to setup employee profile. Before Advice");
    }



    @After("selectAll()")
    public void afterAdvice(){
        System.out.println("Employee setup completed. After Advice");
    }



    @AfterReturning(value = "execution(* com.spring.aop.Employee.returning())",returning = "val")
    public void afterReturning(String val){
        System.out.println("Employee setup Returning  = "+val);

    }

    @After("beanDesignator")
    public void beanDesignatorImple(){
        System.out.println("bean Designator Implementation");
    }




//    @AfterThrowing("throwAndReturn()")
//    public void afterthrowng(){
//        System.out.println("Employee setup throwing.");
//    }


//    @Around("execution(String com.spring.aop.Employee.palin(String))")
//    public String aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
//        System.out.println("Around advice execution."+jp);
//
//        Object[] args = jp.getArgs();
//        args[0] = "hello";
//        String val = (String) jp.proceed(args);
//        return "anas";
//    }

    @Around("execution(String com.spring.aop.Employee.palin(String))")
    public String aroundAdvice() throws Throwable {
        System.out.println("Around advice execution.1");

        return "anas";
    }

}