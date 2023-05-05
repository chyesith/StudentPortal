package com.example.studentportal.services;


import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.Student;
import com.example.studentportal.models.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> login(String email, String password) {
        return studentRepository.findByEmailAndPassword(email , password);
    }

    @Override
    public void authentication(String userName, String password) {

    }

    @Override
    public ResponseEntity<Student> createStudentProfile(StudentDTO student) {
       try {
           Student _student = this.studentRepository.save(student.toEntity());
            return new ResponseEntity<>(_student , HttpStatus.CREATED);
       }catch (Exception e) {
           return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }


    @Override
    public ResponseEntity<Student> updateStudentProfile(Student student) {
        Optional<Student> existingStudent = studentRepository.findById(student.getId());

        if (existingStudent.isPresent()) {
            Student _student = existingStudent.get();
            return new ResponseEntity<>(studentRepository.save(_student), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<HttpStatus> delete(Long id) {
        try {
            studentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
