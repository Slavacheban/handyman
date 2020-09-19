package com.example.handyman.controller;

import com.example.handyman.controller.dto.UserDTO;
import com.example.handyman.controller.transformer.UserTransformer;
import com.example.handyman.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    UserService userService;
    UserTransformer userTransformer;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        UserDTO dto = userTransformer.createDTO(userService.getUserById(id));
        return dto != null ? dto : new UserDTO();
    }
}
