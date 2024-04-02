package com.accolite.hibernate;

import com.accolite.entity.Course;
import com.accolite.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudent {
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
            List<Student> theStudents;
            String query;

            //Start transaction
            session.beginTransaction();

            //Read Query 		(Use java property names, not database column names)
            query = "FROM Student s WHERE s.age<25 ";
            query = "FROM Student";
            theStudents = session.createQuery(query).getResultList();

            //Display results of the read query
            displayStudents(theStudents);

            //Update Query
            query = "UPDATE Student SET age=19 WHERE rollNo=1 ";
            session.createQuery(query).executeUpdate();   //returns number of rows affected

            //Delete Query
            query = "DELETE FROM Student WHERE studentName='Robb' ";
            session.createQuery(query).executeUpdate();   //returns number of rows affected

            //Join
//            query = "FROM Student s inner join s.courses c";
//            List resultList = session.createQuery(query).getResultList();
//            System.out.println(resultList);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents)
            System.out.println(tempStudent);
    }

}
