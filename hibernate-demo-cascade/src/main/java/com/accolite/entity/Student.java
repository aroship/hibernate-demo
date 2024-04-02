package com.accolite.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLL_NO")
    private Integer rollNo;

    @Column(name = "STUDENT_NAME")
    private String studentName;

    @Column(name = "AGE")
    private Integer age;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Course> courses;

    public Student(String name, Integer age) {
        this.studentName = name;
        this.age = age;
    }

    public Student(String name, Integer age, List<Course> courses) {
        this.studentName = name;
        this.age = age;
        this.courses = courses;
    }
}
