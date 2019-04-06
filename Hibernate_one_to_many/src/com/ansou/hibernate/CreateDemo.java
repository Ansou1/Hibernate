package com.ansou.hibernate;

import com.ansou.hibernate.entity.Course;
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
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            Instructor tempInstructor = new Instructor("Sohyeon", "Shin", "sohyeon@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("youtube/video.com", "Gaming");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();
            session.save(tempInstructor);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
