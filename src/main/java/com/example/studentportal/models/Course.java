package com.example.studentportal.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


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
  //  @Column(name = "course_id", updatable = false)
    Long id;

    @Column(name = "description",  nullable = false , columnDefinition = "TEXT")

    String description;
    @Column(name = "course_name", nullable = false , columnDefinition = "TEXT")

    String courseName;

    @Column(name = "course_fee",  nullable = false)
    Double courseFee;



    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST,
            mappedBy = "enrolledCourses")
    @JsonIgnore
    Set<Student> enrolled = new HashSet<Student>();


    public Course( String description, String courseName , Double courseFee) {
        this.description = description;
        this.courseName = courseName;
        this.courseFee = courseFee;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Student> getEnrolled() {
        return enrolled;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + id +
                ", description='" + description + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseFee=" + courseFee +
                '}';
    }
}
