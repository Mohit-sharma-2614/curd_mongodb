package com.example.mongodbb.controllers;

import com.example.mongodbb.entity.StudentEntity;
import com.example.mongodbb.services.StudentServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @GetMapping("/student/{studentId}")
    public StudentEntity findStudentById(@PathVariable ObjectId studentId){
        return studentServices.getStudent(studentId);
    }
    @GetMapping("/students")
    public List<StudentEntity> getAllStudents(){
        return studentServices.getAll();
    }
    @PostMapping("/student")
    public String addStudent(@RequestBody StudentEntity newStudent){
        return studentServices.addStudent(newStudent);
    }
    @PutMapping("/student")
    public StudentEntity updateStudent(@PathVariable ObjectId studentId,@RequestBody StudentEntity updateStudent){
        return studentServices.updateStudent(studentId,updateStudent);
    }
    @DeleteMapping("/student/{studentId}")
    public String deleteStudent(@PathVariable ObjectId studentId){
        return studentServices.deleteOneStudent(studentId);
    }
}