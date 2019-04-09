package com.ansou.spring.hibernate.dao;

import com.ansou.spring.hibernate.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);
}
