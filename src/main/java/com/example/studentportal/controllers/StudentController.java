package com.example.studentportal.controllers;

import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.Student;
import com.example.studentportal.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private  StudentService studentService;


    @PostMapping("api/v1/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    private void registration(@RequestBody StudentDTO student) {

    }

    @PostMapping("api/v1/update")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Student> createOrUpdateStudent(@Valid @RequestBody  StudentDTO student) {
       return this.studentService.addNewStudent(student);
    }

    @GetMapping("api/v1/delete/{id}")
    public void deleteStudentById(@PathVariable Long id){
        //this.studentService.
    }


}
