package com.accolite.hibernate;

import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {
            //Start transaction
            session.beginTransaction();

            //retrieve the student object based on primary key
            int studentId = 1;
            System.out.println("Retrieving student object with id = ." + studentId);
            Student tempStudent = session.get(Student.class, studentId);

            //Update the retrieved student
            System.out.println("Updating student..");
            tempStudent.setAge(30);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Updated!");
        } finally {
            factory.close();
        }
    }

}
