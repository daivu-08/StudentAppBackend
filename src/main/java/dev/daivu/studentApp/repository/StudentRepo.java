package dev.daivu.studentApp.repository;

import dev.daivu.studentApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
