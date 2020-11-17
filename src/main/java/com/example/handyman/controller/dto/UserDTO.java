package com.example.handyman.controller.dto;

import com.example.handyman.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO{
    @Size(min=2, max=30)
    private String firstName;
    @Size(min=2, max=30)
    private String lastName;
    @Email
    private String login;
    @Null
    private String password;
    private Role role;
}
