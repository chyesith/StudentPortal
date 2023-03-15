package com.example.studentportal.services;

import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {

    void authentication(String userName , String password);
    ResponseEntity<Student> addNewStudent(StudentDTO student);


    ResponseEntity<Student> updateStudentProfile(Student student , Long id);


    ResponseEntity<?> delete(Long id);
    //TODO add new student return class



}
