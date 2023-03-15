package com.example.studentportal.services;

import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.Student;

public interface StudentService {


    Student findByEmail(String email);

    void authentication(String userName , String password);
    void addNewStudent(StudentDTO student);


    void updateStudentProfile(Student student);
    //TODO add new student return class



}
