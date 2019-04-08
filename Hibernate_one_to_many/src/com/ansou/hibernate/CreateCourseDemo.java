package com.ansou.hibernate;

import com.ansou.hibernate.entity.Course;
import com.ansou.hibernate.entity.Instructor;
import com.ansou.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();

            Instructor tempInstructor = session.get(Instructor.class, 1);

            Course firstCourse = new Course("Design");
            Course secondCourse = new Course("Painting");
            Course thirdCourse = new Course("Music");
            Course fourthCourse = new Course("Dancing");
            Course fifthCourse = new Course("Cooking");

            tempInstructor.add(firstCourse);
            tempInstructor.add(secondCourse);
            tempInstructor.add(thirdCourse);
            tempInstructor.add(fourthCourse);
            tempInstructor.add(fifthCourse);

            session.save(firstCourse);
            session.save(secondCourse);
            session.save(thirdCourse);
            session.save(fourthCourse);
            session.save(fifthCourse);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
