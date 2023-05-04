package com.example.studentportal.models;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "Students")
@Table(name = "Students", uniqueConstraints = {
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
    //@Column(name = "student_id", updatable = false)
    Long id;

    @Column(name = "first_name", nullable = false, columnDefinition = "TEXT")
    String firstName;
    @Column(name = "last_name", nullable = false, columnDefinition = "TEXT")
    String lastName;

    @Column(name = "email", nullable = false, columnDefinition = "TEXT")
    String email;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    String password;

    @Column(name = "graduation_eligibility", nullable = false, columnDefinition = "BOOLEAN")
    Boolean graduationEligibility;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinTable(
            name = "enrolled_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    Set<Course> enrolledCourses = new HashSet<Course>();

    public Student(String firstName, String lastName, String email, String password, Boolean graduationEligibility, Set<Course> enrolledCourses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.graduationEligibility = graduationEligibility;
        this.enrolledCourses = enrolledCourses;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getGraduationEligibility() {
        return graduationEligibility;
    }

    public Set<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGraduationEligibility(Boolean graduationEligibility) {
        this.graduationEligibility = graduationEligibility;
    }

    public void setEnrolledCourses(Set<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void addCourseF(Course course){
        this.enrolledCourses.add(course);
        //course.getEnrolled().add(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", graduationEligibility=" + graduationEligibility +
                ", enrolledCourses=" + enrolledCourses +
                '}';
    }
}
