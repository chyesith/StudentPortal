package com.example.studentportal.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity(name = "Course")
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    Double courseFee;


    public Course( String description, String courseName , Double courseFee) {
        this.description = description;
        this.courseName = courseName;
        this.courseFee = courseFee;
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
    public Double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Double courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", description='" + description + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}
