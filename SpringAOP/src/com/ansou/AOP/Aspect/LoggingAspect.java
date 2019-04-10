package com.ansou.AOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(public void com.ansou.AOP.DAO.AccountDAO.addAccount())")
    public void beforeAddAccount() {
        System.out.println("This has been executed before AddAccount");
    }
}
