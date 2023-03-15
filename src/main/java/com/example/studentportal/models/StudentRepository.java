package com.example.studentportal.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Long> {
   Student findStudentByEmail(String email);
}
