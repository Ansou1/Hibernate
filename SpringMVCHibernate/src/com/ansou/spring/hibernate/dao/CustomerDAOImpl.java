package com.ansou.spring.hibernate.dao;

import com.ansou.spring.hibernate.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Customer ORDER BY lastName", Customer.class).getResultList();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomers(int theId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, theId);
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Customer.class, theId));
    }
}
