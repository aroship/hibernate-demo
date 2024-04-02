package com.accolite.hibernate;

import com.accolite.entity.Course;
import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class Create {
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

            //Create a student object
            System.out.println("Creating student object...");
            Student tempStudent = new Student("Robb", 21);

            //Create a course object
            System.out.println("Creating course object...");
            Course course1 = new Course("Java", 2000.0, tempStudent);
            Course course2 = new Course("Python", 1000.0, tempStudent);
            List<Course> courses = new ArrayList<>();
            courses.add(course1);
            courses.add(course2);

            tempStudent.setCourses(courses);

            //Start transaction
            session.beginTransaction();

            //save the student object
            session.save(tempStudent);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Saved!");
        } finally {
            factory.close();
        }
    }

}
