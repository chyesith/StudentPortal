package com.example.studentportal.models;


import jakarta.persistence.*;

@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {
        @UniqueConstraint(name = "student_email_unique", columnNames = "email")
})

public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1

    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_sequence")
    @Column(name = "studentId", updatable = false)
    Long studentId;

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    String email;

    @Column(name = "graduation_eligibility", nullable = false, columnDefinition = "tinyint(1) default(1)")
    Boolean graduationEligibility;

    public Student(Long studentId, String firstName, String lastName, String email) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
