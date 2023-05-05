package com.example.studentportal.controllers;

import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.Student;
import com.example.studentportal.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private  StudentService studentService;



    @CrossOrigin("*")
    @PostMapping("api/v1/student/create")
    @ResponseBody
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentDTO student) {
       return this.studentService.createStudentProfile(student);
    }

    @CrossOrigin("*")
    @PostMapping("/api/v1/student/login")
    public Optional<Student> loginStudent(@RequestBody Student student) {
        return studentService.login(student.getEmail(), student.getPassword());

    }

    @CrossOrigin("*")
    @PutMapping ("api/v1/student/update")
    @ResponseBody
    public ResponseEntity<Student> update(@Valid @RequestBody  Student student) {
        return this.studentService.updateStudentProfile(student);
    }


    @CrossOrigin("*")
    @DeleteMapping("api/v1/student/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStudentById(@PathVariable Long id){
       return this.studentService.delete(id);
    }


}
