package dev.daivu.studentApp.service;

import dev.daivu.studentApp.model.Student;
import dev.daivu.studentApp.repository.StudentRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Student updateStudent(int studentId, Student newStudent) {
        Student optionalStudent = studentRepo.findById(studentId).orElse(null);
        if (optionalStudent!=null) {
            Student updatedStudent = optionalStudent;
            updatedStudent.setName(newStudent.getName());
            updatedStudent.setMarks(newStudent.getMarks());
            studentRepo.save(updatedStudent);
            return updatedStudent;
        } else {
            // Handle case where student with given ID is not found
            throw new RuntimeException("Student not found with id: " + studentId);
        }
    }

    public Student deleteStudent(int id){
        Student student = studentRepo.findById(id).orElse(null);
        if(student!=null){
            studentRepo.deleteById(id);
        }else {
            // Handle case where student with given ID is not found
            throw new RuntimeException("Student not found with id: " + id);
        }
        return student;
    }

}
