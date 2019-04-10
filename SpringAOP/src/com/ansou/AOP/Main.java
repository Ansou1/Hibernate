package com.ansou.AOP;

import com.ansou.AOP.DAO.AccountDAO;
import com.ansou.AOP.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        theAccountDAO.addAccount();
        theMembershipDAO.addAccount();
        context.close();
    }
}
