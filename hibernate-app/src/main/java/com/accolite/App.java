package com.accolite;

import com.accolite.entity.Student;
import com.accolite.service.StudentService;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello");
        StudentService studentService = new StudentService();

        boolean flag = true;
        while (flag) {
            System.out.println("Enter: ");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    studentService.save(new Student("Bran", 33));
                    break;
                case 2:
                    Student serviceById = studentService.getById(1);
                    System.out.println(serviceById);
                    break;
                case 3:
                default:
                    flag = false;
                    studentService.closeSessionFactory();
                    break;
            }
        }
    }
}
