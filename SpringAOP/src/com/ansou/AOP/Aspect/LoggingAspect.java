package com.ansou.AOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(public void com.ansou.AOP.DAO.AccountDAO.addAccount())")
    private void forDaopackage() {}


    @Before("forDaopackage()")
    public void beforeAddAccount() {
        System.out.println("This has been executed before AddAccount");
    }

    @Before("forDaopackage()")
    public void performApiAnalytics() {
        System.out.println("API analytics");
    }
}
