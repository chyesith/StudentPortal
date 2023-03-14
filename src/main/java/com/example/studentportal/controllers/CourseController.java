package com.example.studentportal.controllers;

import com.example.studentportal.models.Course;
import com.example.studentportal.services.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class CourseController {
    private CourseService courseService;


    @GetMapping("/courses")
    List<Course> all() {
       return this.courseService.viewAllCourses();
    }
}
