package com.ansou.hibernate;

import com.ansou.hibernate.entity.Instructor;
import com.ansou.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();

            InstructorDetail tmpInstructorDetail = session.get(InstructorDetail.class, 1);

            System.out.println(tmpInstructorDetail.toString());
            System.out.println(tmpInstructorDetail.getInstructor().toString());

            tmpInstructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(tmpInstructorDetail);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
