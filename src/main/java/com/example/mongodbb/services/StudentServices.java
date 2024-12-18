package com.example.mongodbb.services;


import com.example.mongodbb.entity.StudentEntity;
import com.example.mongodbb.repository.StudentRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Objects;

@Component
public class StudentServices {

    @Autowired
    private StudentRepo studentRepo;

    public List<StudentEntity> getAll(){
        return studentRepo.findAll();
    }
    public StudentEntity getStudent(ObjectId studentId){
        return studentRepo.findById(studentId).orElse(null);
    }
    public String addStudent(StudentEntity newStudent){
        try {
            studentRepo.insert(newStudent);
            return "Ok!";
        } catch (Exception e){
            System.err.println("Error while adding student: " + e.getMessage());
            return "Failed to add student: " + e.getMessage();
        }
    }
    public StudentEntity updateStudent(ObjectId studentId,StudentEntity newFields){

        StudentEntity oldStudent = studentRepo.findById(studentId).orElse(null);
        try {
            assert oldStudent != null;
            oldStudent.setAge(oldStudent.getAge() != newFields.getAge()? newFields.getAge() : oldStudent.getAge());
            oldStudent.setCity(oldStudent.getCity() == null && !Objects.equals(oldStudent.getCity(), newFields.getCity()) ? newFields.getCity() : oldStudent.getCity());
            oldStudent.setName(oldStudent.getName() == null && !Objects.equals(oldStudent.getName(), newFields.getName()) ? newFields.getName() : oldStudent.getName());

            return oldStudent;
        } catch (Exception e){
            System.err.println("Failed to update student: " + e.getMessage());
            return oldStudent;
        }
    }
    public String deleteOneStudent(ObjectId studentId){
        studentRepo.deleteById(studentId);
        return "Ok!";
    }
}
