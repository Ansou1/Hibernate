package com.ansou.hibernate;

import com.ansou.hibernate.entity.Instructor;
import com.ansou.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            Instructor tempInstructor = new Instructor("Simon", "Daguenet", "simondaguenet81@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube/JavaTutorial.com", "Fishing");

            //Instructor tempInstructor = new Instructor("Eunju", "Shin", "cheesee@gmail.com");
            //InstructorDetail tempInstructorDetail = new InstructorDetail("youtube/cheese.com", "Eating");


            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();
            session.save(tempInstructor);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
