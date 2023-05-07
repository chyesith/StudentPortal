package com.example.studentportal.dtos;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Enroll {
    @NonNull
    private Long courseId;
    @NonNull
    private Long studentId;
}
