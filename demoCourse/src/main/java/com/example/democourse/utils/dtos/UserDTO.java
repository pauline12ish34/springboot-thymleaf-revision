package com.example.democourse.utils.dtos;

import com.example.democourse.utils.security.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotEmpty
    private String fullNames;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    @ValidPassword
    private String password;
}
