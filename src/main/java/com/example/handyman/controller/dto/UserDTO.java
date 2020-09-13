package com.example.handyman.controller.dto;

import com.example.handyman.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO extends BaseDTO{
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Role role;
}
