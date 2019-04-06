package com.ansou.hibernate;

import com.ansou.hibernate.entity.Course;
import com.ansou.hibernate.entity.Instructor;
import com.ansou.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();

            Query<Instructor> querry = session.createQuery("SELECT i FROM instructor i JOIN FETCH i.courses WHERE i.id=:theInstructorId", Instructor.class);
            querry.setParameter("theInstructorId", 1);

            Instructor tempInstructor = querry.getSingleResult();

            System.out.println(tempInstructor);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
