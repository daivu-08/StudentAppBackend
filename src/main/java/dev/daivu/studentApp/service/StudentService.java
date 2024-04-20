package dev.daivu.studentApp.service;

import dev.daivu.studentApp.model.Student;
import dev.daivu.studentApp.repository.StudentRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public Student addStudent(int id,String name, int marks){
        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setMarks(marks);

        studentRepo.save(student);
        return student;
    }
    public List<Student> getStudents(){
        List<Student> students= new ArrayList<>();
        students=studentRepo.findAll();
        return students;
    }
}
