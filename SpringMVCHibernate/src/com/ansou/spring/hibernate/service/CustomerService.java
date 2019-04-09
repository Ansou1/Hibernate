package com.ansou.spring.hibernate.service;

import com.ansou.spring.hibernate.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomers(int theId);

    public void deleteCustomer(int theId);
}
