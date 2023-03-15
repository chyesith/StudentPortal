package com.example.studentportal.controllers;

import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.Student;
import com.example.studentportal.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private  StudentService studentService;


    private void registration(StudentDTO student) {
        Student exsistingStudent  = studentService.findByEmail(student.getEmail());
        if (exsistingStudent != null) {
            //TODO send response
        } else {
            this.studentService.addNewStudent(student);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createOrUpdateStudent(StudentDTO studentDTO) {

    }

    @GetMapping("/delete/{id}")
    public void deleteStudentById(@PathVariable Long id){
        //this.studentService.
    }


}
