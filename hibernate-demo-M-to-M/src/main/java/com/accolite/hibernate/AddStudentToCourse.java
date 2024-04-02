package com.accolite.hibernate;

import com.accolite.entity.Course;
import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class AddStudentToCourse {
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
            Student tempStudent1 = new Student("Jake", 22);

            //Start transaction
            session.beginTransaction();

            final Course course = session.get(Course.class, 1);
            course.getStudents().add(tempStudent1);

            final List<Course> courses = tempStudent1.getCourses();
            courses.add(course);
            tempStudent1.setCourses(courses);

            session.save(tempStudent1);
            session.save(course);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Saved!");
        } finally {
            factory.close();
        }
    }

}
