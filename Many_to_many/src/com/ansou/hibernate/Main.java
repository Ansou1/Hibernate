package com.ansou.hibernate;

import com.ansou.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();

            /*
            Course tempCourse = new Course("Java tutorial with different framework");
            session.save(tempCourse);

            Student tempStudent1 = new Student("Eunju", "Shin", "napa@gmail.com");
            Student tempStudent2 = new Student("Sohyeon", "Shin", "longstrok@gmail.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            session.save(tempStudent1);
            session.save(tempStudent2);
            */

            /*
            Student napaJagi = session.get(Student.class, 1);

            Course tempCourse1 = new Course("Being napa to anyone");
            Course tempCourse2 = new Course("Ikea: how to become a sect member?");

            napaJagi.addCourses(tempCourse1);
            napaJagi.addCourses(tempCourse2);

            session.save(tempCourse1);
            session.save(tempCourse2);
            */

            Student course = session.get(Student.class, 1);

            System.out.println(course);

            session.delete(course);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
