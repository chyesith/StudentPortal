package com.example.studentportal.controllers;

import com.example.studentportal.dtos.CourseDTO;
import com.example.studentportal.models.Course;
import com.example.studentportal.services.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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


    @CrossOrigin("*")
    @GetMapping("api/v1/courses")
    List<Course> all() {
        return this.courseService.viewAllCourses();
    }


    @CrossOrigin("*")
    @PostMapping("api/v1/courses/enroll/{courseId}/{studentId}")
    Course enrollCourseByStudentId(@PathVariable(value = "studentId") Long studentId, @PathVariable(value = "courseId") Long courseId) throws Exception {
        return this.courseService.enrollCourseBySid(studentId, courseId);
    }

    @GetMapping ("api/v1/courses/enrolled/{studentId}")
    Set<Course> enrolledCourses(@PathVariable(value = "studentId") Long sid)  {
        return this.courseService.enrolledCoursesBySid(sid);
    }
}
