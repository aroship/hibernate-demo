package com.accolite.hibernate;

import com.accolite.entity.Course;
import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Read {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            //retrieve the student object based on primary key
            Student tempStudent = session.get(Student.class, 1);
            final Course course = session.get(Course.class, 1);

            System.out.println(tempStudent);
            System.out.println(course);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}
