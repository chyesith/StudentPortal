package com.example.studentportal.services;

import com.example.studentportal.dtos.CourseDTO;
import com.example.studentportal.models.Course;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface CourseService {
    Course addNew(CourseDTO course);

    Set<Course> enrolledCoursesBySid(Long sid);

    //TODO add class
    List<Course> viewAllCourses();

    Course enrollCourseBySid(Long sid , Long cid) throws Exception;
}
