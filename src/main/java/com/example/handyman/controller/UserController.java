package com.example.handyman.controller;

import com.example.handyman.controller.dto.UserDTO;
import com.example.handyman.controller.transformer.UserTransformer;
import com.example.handyman.entity.UserEntity;
import com.example.handyman.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;
    private UserTransformer userTransformer;

    @GetMapping(value = "users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable(name = "id") Long id) {
        UserEntity user = userService.getUserById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        UserDTO result = userTransformer.createDTO(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
