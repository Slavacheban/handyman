package com.example.handyman.controller.dto;


import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String username;
    private String password;
}
