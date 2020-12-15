package com.example.handyman.controller;

import com.example.handyman.controller.dto.AuthenticationRequestDTO;
import com.example.handyman.entity.UserEntity;
import com.example.handyman.exception.JwtAuthenticationException;
import com.example.handyman.security.JwtTokenProvider;
import com.example.handyman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/auth/")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDTO requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            Optional<UserEntity> userEntityOptional = userService.getUserByLogin(username);

            if (userEntityOptional.isPresent()) {
                UserEntity user = userEntityOptional.get();
                String token = jwtTokenProvider.createToken(username, user.getRoles());

                Map<Object, Object> response = new HashMap<>();
                response.put("username", username);
                response.put("token", token);

                return ResponseEntity.ok(response);
            }

            throw new UsernameNotFoundException("User with username: " + username + " not found");
        } catch (JwtAuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
