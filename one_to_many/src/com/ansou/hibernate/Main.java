package com.ansou.hibernate;

import com.ansou.hibernate.entity.Course;
import com.ansou.hibernate.entity.Instructor;
import com.ansou.hibernate.entity.InstructorDetail;
import com.ansou.hibernate.entity.Review;
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
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();

            /*Course myCourse = new Course("Java tutorial with frameworks");

            Review firstReview = new Review("Very good :)");
            Review secondReview = new Review("Good");
            Review thirdReview = new Review("It's okay");
            Review fourthReview = new Review("The course is lacking of information");
            Review fifthReview = new Review("The course is useless");

            myCourse.add(firstReview);
            myCourse.add(secondReview);
            myCourse.add(thirdReview);
            myCourse.add(fourthReview);
            myCourse.add(fifthReview);

            session.save(myCourse);*/

            /*
            Course myCourse = session.get(Course.class, 10);
            System.out.println(myCourse);
            System.out.println(myCourse.getReviews());
            */

            Course myCourse = session.get(Course.class, 10);
            session.delete(myCourse);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
