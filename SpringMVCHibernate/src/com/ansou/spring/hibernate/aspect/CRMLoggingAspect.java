package com.ansou.spring.hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.ansou.spring.hibernate.controller.*.*(..))")
    private void forControllerPackage() { }

    @Pointcut("execution(* com.ansou.spring.hibernate.service.*.*(..))")
    private void forServicePackage() { }

    @Pointcut("execution(* com.ansou.spring.hibernate.dao.*.*(..))")
    private void forDaoPackage() { }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() { }


    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toString();
        myLogger.info("@Before method => " + method);

        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            myLogger.info("Arguments of the method => " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
        String method = joinPoint.getSignature().toString();
        myLogger.info("@AfterReturning method => " + method);

        myLogger.info("theResult => " + theResult);
    }

}
