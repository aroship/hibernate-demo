package com.accolite.hibernate;

import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudent {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;

            //Start transaction
            session.beginTransaction();

            //retrieve the student object based on primary key
            System.out.println("Retrieving student object with id = ." + studentId);
            Student tempStudent = session.get(Student.class, studentId);
            System.out.println(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}
