package com.example.studentportal.controllers;

import com.example.studentportal.dtos.CourseDTO;
import com.example.studentportal.models.Course;
import com.example.studentportal.services.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("api/v1/addCourse")
    Course save(@RequestBody CourseDTO course) {
        return  this.courseService.addNew(course);
    }


    @GetMapping("api/v1/courses")
    List<Course> all() {
       return this.courseService.viewAllCourses();
    }
}
