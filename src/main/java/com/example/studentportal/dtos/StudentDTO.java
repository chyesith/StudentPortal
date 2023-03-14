package com.example.studentportal.dtos;

import lombok.AllArgsConstructor;
import lombok.NonNull;


@AllArgsConstructor
public class StudentDTO {
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String email;
    @NonNull
    private String password;

}
