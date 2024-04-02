package com.accolite.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "COURSE_ID")
    private Course course;

    public Student(String name, Integer age) {
        this.studentName = name;
        this.age = age;
    }

    public Student(String name, Integer age, Course course) {
        this.studentName = name;
        this.age = age;
        this.course = course;
    }
}
