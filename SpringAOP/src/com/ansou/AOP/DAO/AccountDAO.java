package com.ansou.AOP.DAO;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work: Adding a global account ");
    }
}
