package com.example.studentportal.services;

import com.example.studentportal.dtos.CourseDTO;
import com.example.studentportal.models.Course;
import com.example.studentportal.models.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addNew(CourseDTO course) {
        return this.courseRepository.save(course.toEntity());
    }

    @Override
    public List<Course> viewAllCourses() {
        return this.courseRepository.findAll();
    }
}
