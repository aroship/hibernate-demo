package com.accolite.demo.controller;

import com.accolite.demo.entity.Student;
import com.accolite.demo.repository.StudentRepository;
import com.accolite.demo.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}
