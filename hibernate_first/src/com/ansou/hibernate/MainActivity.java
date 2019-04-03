package com.ansou.hibernate;

import com.ansou.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainActivity {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
            // Save
            save(session, "Simon", "Daguenet", "Rakuten");
            save(session, "Eunju", "Shin", "Ikea");
            save(session, "Roland", "Idemyr", "Ikea");
            save(session, "Cia", "Johanson", "Ikea");
            //retrieveOneElementFromID(session, 2);
            //retrieveListEmployeeFromCompany(session, "'Ikea'");
            //delete(session, 1);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }

    }

    private static void delete(Session session, int id) {
        Employee getEmployee = session.get(Employee.class, id);
        session.delete(getEmployee);
    }

    private static void retrieveListEmployeeFromCompany(Session session, String search) {
        List<Employee> listEmployee = session.createQuery("FROM Employee e WHERE e.compnay LIKE " + search).getResultList();
        displayEmployee(listEmployee);
        session.getTransaction().commit();
    }

    private static void retrieveOneElementFromID(Session session, int id) {
        Employee simon = session.get(Employee.class, id);
        System.out.println(simon);
    }

    private static void save(Session session, String firstName, String lastName, String company) {
        Employee newEmployee = new Employee(firstName, lastName, company);
        session.save(newEmployee);
    }

    private static void displayEmployee(List<Employee> listOfEmployee) {
        for (Employee item: listOfEmployee) {
            System.out.println(item);
        }
    }
}
