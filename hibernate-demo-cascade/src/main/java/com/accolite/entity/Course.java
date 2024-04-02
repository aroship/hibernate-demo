package com.accolite.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    private String courseName;

    private Double fees;

    @ManyToOne
    @JoinColumn(name = "ROLL_NO")
    private Student student;

    public Course(String courseName, Double fees) {
        this.courseName = courseName;
        this.fees = fees;
    }

    public Course(String courseName, Double fees, Student student) {
        this.courseName = courseName;
        this.fees = fees;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", fees=" + fees +
                '}';
    }
}
