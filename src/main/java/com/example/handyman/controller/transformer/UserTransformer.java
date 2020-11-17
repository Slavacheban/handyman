package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.UserDTO;
import com.example.handyman.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserTransformer extends Transformer<UserEntity, UserDTO> {

    @Override
    public UserDTO createDTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setLogin(entity.getLogin());
        dto.setRole(entity.getRole());
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
        entity.setRole(dto.getRole());
        entity.setCreateDate(dto.getCreateDate());
        entity.setUpdateDate(dto.getUpdateDate());
        return entity;
    }
}
