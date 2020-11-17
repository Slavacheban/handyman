package com.example.handyman.controller;

import com.example.handyman.controller.dto.UserDTO;
import com.example.handyman.controller.transformer.UserTransformer;
import com.example.handyman.entity.UserEntity;
import com.example.handyman.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private UserService userService;
    private UserTransformer userTransformer;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        UserEntity entity = userService.getUserById(id);
        UserDTO dto = userTransformer.createDTO(entity);
        return dto;
    }

    @GetMapping("/")
    public List<UserDTO> getAllUsers() {
        List<UserEntity> entitys = userService.getAll();
        List<UserDTO> dtos = userTransformer.createDTOList(entitys);
        return dtos;
    }
}
