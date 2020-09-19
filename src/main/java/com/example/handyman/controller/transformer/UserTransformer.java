package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.BaseDTO;
import com.example.handyman.controller.dto.UserDTO;
import com.example.handyman.entity.BaseEntity;
import com.example.handyman.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTransformer implements Transformer<UserEntity, UserDTO> {

    @Override
    public UserDTO createDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setLogin(entity.getLogin());
        dto.setPassword(entity.getPassword());
        dto.setCreateDate(entity.getCreateDate());
        dto.setUpdateDate(entity.getUpdateDate());
        return dto;
    }

    @Override
    public UserEntity createEntity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setLogin(dto.getLogin());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        entity.setCreateDate(dto.getCreateDate());
        entity.setUpdateDate(dto.getUpdateDate());
        return entity;
    }

    @Override
    public List<UserDTO> createDTOList(List<UserEntity> entityList) {
        return entityList.stream().map(this::createDTO).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> createEntityList(List<UserDTO> userDTOS) {
        return userDTOS.stream().map(this::createEntity).collect(Collectors.toList());
    }
}
