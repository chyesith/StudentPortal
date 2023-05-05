package com.example.studentportal.dtos;


import com.example.studentportal.models.Course;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class CourseDTO {


    @NonNull
    String courseName;
    String description;
    @NonNull
    double courseFee;

    public Course toEntity() {
        return  new Course( this.description , this.courseName  , this.courseFee);
    }

}

