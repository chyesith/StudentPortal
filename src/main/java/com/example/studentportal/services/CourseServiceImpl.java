package com.example.studentportal.services;

import com.example.studentportal.dtos.CourseDTO;
import com.example.studentportal.models.Course;
import com.example.studentportal.models.CourseRepository;
import com.example.studentportal.models.Student;
import com.example.studentportal.models.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Course addNew(CourseDTO course) {
        return this.courseRepository.save(course.toEntity());
    }

    @Override
    public List<Course> viewAllCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course enrollCourseBySid(Long sid, Long cid) throws Exception {
        Optional<Student> student = studentRepository.findById(sid);
        Optional<Course> course = courseRepository.findById(sid);
        if (course.isEmpty()) {
            throw new Exception("course not found for id: " + cid);
        } else {
            Course current =  course.get();
            student.ifPresent(value -> value.addCourseF(current));
            studentRepository.save(student.get());
            return courseRepository.save(current);
        }
    }
}
