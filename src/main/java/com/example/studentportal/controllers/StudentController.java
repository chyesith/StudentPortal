package com.example.studentportal.controllers;

import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.StudentRepository;
import com.example.studentportal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private  StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void addNewStudent(StudentDTO studentDTO) {

    }
}
