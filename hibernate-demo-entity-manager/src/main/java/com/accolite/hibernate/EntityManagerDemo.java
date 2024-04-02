package com.accolite.hibernate;

import com.accolite.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class EntityManagerDemo {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {

            //SAVE
            entityManager.getTransaction().begin();
            System.out.println("Creating Student");
            Student student = new Student("John", 22);
            entityManager.persist(student);
            entityManager.getTransaction().commit();

            //READ
            entityManager.getTransaction().begin();
            System.out.println("Retrieving student object with id = ." + 1);
            student = entityManager.find(Student.class, 1);
            System.out.println(student);
            entityManager.getTransaction().commit();

            //DELETE
            entityManager.getTransaction().begin();
            System.out.println("Deleting student object with id = ." + 1);
            entityManager.remove(student);
            entityManager.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            entityManagerFactory.close();
        }
    }

}
