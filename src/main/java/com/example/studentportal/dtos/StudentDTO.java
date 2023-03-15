package com.example.studentportal.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class StudentDTO   {
    @NonNull
    private Long sid;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String email;
    @NonNull
    private String password;

}
