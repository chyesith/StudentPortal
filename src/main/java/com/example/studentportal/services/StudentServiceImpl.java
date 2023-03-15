package com.example.studentportal.services;


import com.example.studentportal.dtos.StudentDTO;
import com.example.studentportal.models.Student;
import com.example.studentportal.models.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;


    @Override
    public Student findByEmail(String email) {
        return this.studentRepository.findStudentByEmail(email);
    }

    @Override
    public void authentication(String userName, String password) {

    }

    @Override
    public void addNewStudent(StudentDTO student) {

    }

    @Override
    public void updateStudentProfile(Student student) {

    }
}
