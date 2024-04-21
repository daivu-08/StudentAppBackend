package dev.daivu.studentApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Student {
    @Id
    private int id;
    private String name;
    private int marks;

    public Student() {
    }

    public Student(Student student) {
        this.id = student.id;
        this.name = student.name;
        this.marks = student.marks;;
    }
}
