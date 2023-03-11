package com.example.studentportal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity(name = "Course")
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1

    )
    @Column(name = "course_id", updatable = false)
    Long courseId;

    @Column(name = "description",  nullable = false , columnDefinition = "TEXT")

    String description;
    @Column(name = "course_name", nullable = false , columnDefinition = "TEXT")

    String courseName;

    @Column(name = "course_fee",  nullable = false)
    double courseFee;

    public Course(Long courseId, String description, String courseName) {
        this.courseId = courseId;
        this.description = description;
        this.courseName = courseName;
    }


    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", description='" + description + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
