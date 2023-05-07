package com.example.studentportal.services;

import com.example.studentportal.dtos.CourseDTO;
import com.example.studentportal.dtos.Enroll;
import com.example.studentportal.models.Course;
import com.example.studentportal.models.CourseRepository;
import com.example.studentportal.models.Student;
import com.example.studentportal.models.StudentRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    public Set<Course> enrolledCoursesBySid(Long sid) {
        Student _student = studentRepository.findStudentById(sid);
        return _student.getEnrolledCourses();
    }

    @Override
    public Course enrollCourseBySid(Enroll enroll) throws Exception {
        Optional<Student> student = studentRepository.findById(enroll.getStudentId());
        Optional<Course> course = courseRepository.findById(enroll.getCourseId());
        if (course.isEmpty()) {
            throw new Exception("course not found for id: " + enroll.getCourseId());
        } else {
            Course current =  course.get();
            student.ifPresent(value -> {value.addCourseF(current);
                value.setGraduationEligibility(false);
            });
            studentRepository.save(student.get());
//            String uri = "http://localhost:8081/invoice";
//            RestTemplate restTemplate = new RestTemplate();
//            Invoice _invoice = new Invoice(current.getCourseFee(), "Course", student.get().getEmail());
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity entity = new HttpEntity(_invoice, headers);
//            ResponseEntity<String> inv = restTemplate.exchange(uri, HttpMethod.POST, entity
//                    , String.class);
            return courseRepository.save(current);
        }
    }
}
