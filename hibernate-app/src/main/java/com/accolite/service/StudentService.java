package com.accolite.service;

import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentService {

    private final SessionFactory sessionFactory;

    public StudentService() {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    public Student getById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Student student = session.get(Student.class, id);

        session.getTransaction().commit();
        session.close();

        return student;
    }

    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(student);
        System.out.println("Saved");

        session.getTransaction().commit();
        session.close();
    }

    public void closeSessionFactory() {
        System.out.println("Connection closed.");
        sessionFactory.close();
    }
}
