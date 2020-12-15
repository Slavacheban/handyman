package com.example.handyman.security;

import lombok.Data;

@Data
public class AuthenticateRequestDTO {
    private String login;
    private String password;
}
