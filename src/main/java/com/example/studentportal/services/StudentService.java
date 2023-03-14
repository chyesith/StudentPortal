package com.example.studentportal.services;

import com.example.studentportal.models.Student;

public interface StudentService {

    void authentication(String userName , String password);
    void addNewStudent(Student  student);


    void updateStudentProfile(Student student);
    //TODO add new student return class



}
