package com.ansou.hibernate;

import com.ansou.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";
        */

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


        try {
            /*System.out.println("Connection to database : " + jdbcURL);

            Connection myConn = DriverManager.getConnection(jdbcURL, user, password);

            System.out.println("Connexion successful!!!");*/
            /*
            Student Sohyeon = new Student("Sohyeon", "Shin", "sophia@gmail.com");
            Student eunju = new Student("Simon", "Daguenet", "eunju@gmail.com");
            Student simon = new Student("Eunju", "Simon", "simon@gmail.com");

            session.beginTransaction();
            session.save(Sohyeon);
            session.save(eunju);
            session.save(simon);
            session.getTransaction().commit();
            */
            /*
            session.beginTransaction();
            Student getStudent = session.get(Student.class, 1);
            System.out.println("Student: => " + getStudent);
            session.getTransaction().commit();
            */

            /*
            session.beginTransaction();
            List<Student> listOfStudent = session.createQuery("FROM Student s WHERE s.email LIKE '%gmail.com'").getResultList();

            displayStudent(listOfStudent);
            */

            session.beginTransaction();
            Student getStudent = session.get(Student.class, 1);
            session.delete(getStudent);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

    private static void displayStudent(List<Student> listOfStudent) {
        for (Student item: listOfStudent) {
            System.out.println(item);
        }
    }
}
