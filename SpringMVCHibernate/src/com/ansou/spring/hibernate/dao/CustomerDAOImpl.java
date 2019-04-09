package com.ansou.spring.hibernate.dao;

import com.ansou.spring.hibernate.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("FROM Customer", Customer.class).getResultList();
        return customerList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(theCustomer);
    }
}
