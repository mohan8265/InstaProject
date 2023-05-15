package com.geekster.IntagramProject.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    @Email
    private String email;
    private String password;
}
