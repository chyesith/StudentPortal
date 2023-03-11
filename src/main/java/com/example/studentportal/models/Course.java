package com.example.studentportal.models;

public class Course {
    Long courseId;
    String description;
    String courseName;

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
