package com.ansou.hibernate;

import com.ansou.hibernate.entity.Instructor;
import com.ansou.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();

            Instructor tmpInstructor = session.get(Instructor.class, 2);
            session.delete(tmpInstructor);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
