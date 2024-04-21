package dev.daivu.studentApp.controller;

import dev.daivu.studentApp.model.Student;
import dev.daivu.studentApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addstudent")
    public ResponseEntity addStudent(@RequestBody Student student){

        Student s1 = studentService.addStudent( student.getId(),student.getName(),student.getMarks());
        return ResponseEntity.ok(s1);
    }

    @GetMapping("/readstudent")
    public  ResponseEntity readStudent(){
        List<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity updateStudent(@PathVariable("id")int id, @RequestBody Student studentDetails){
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/deletestudent")
    public ResponseEntity deleteStudent(@RequestBody Integer id){
        Student deletedStudent = studentService.deleteStudent(id);
        return ResponseEntity.ok(deletedStudent);
    }

}
