package com.example.studentportal.dtos;

import com.example.studentportal.models.Course;
import com.example.studentportal.models.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Getter
@Setter
public class StudentDTO   {

    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String email;
    @NonNull
    private String password;

    private Boolean graduationEligibility;

    private Set<Course> enrolledCourses = new HashSet<Course>();

    public Student toEntity() {
        return  new Student(this.firstname , this.lastname , this.email , this.password,this.graduationEligibility , this.enrolledCourses  );
    }


}
