package com.example.studentportal.services;


import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.Student;
import com.example.studentportal.models.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;


    @Override
    public void authentication(String userName, String password) {

    }

    @Override
    public ResponseEntity<Student> addNewStudent(StudentDTO student) {
        //TODO check email exsting on the model name a
        return null;
    }

    @Override
    public ResponseEntity<Student> updateStudentProfile(Student student, Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return null;
    }
}
