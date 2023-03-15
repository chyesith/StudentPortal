package com.example.studentportal.dtos;


import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class CourseDTO {

    @NonNull
    String courseName;
    String description;
    @NonNull
    double fee;

}

