package com.example.studentportal.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student , Long> {
   Student findStudentByEmail(String email);

   Student findStudentById(Long id);

   Optional<Student> findByEmailAndPassword(String email, String password);
}
