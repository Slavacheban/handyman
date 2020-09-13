package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.BaseDTO;
import com.example.handyman.controller.dto.UserDTO;
import com.example.handyman.entity.BaseEntity;
import com.example.handyman.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserTransformer implements Transformer {
    @Override
    public BaseDTO createDTO(BaseEntity baseEntity) {
        UserEntity entity = (UserEntity) baseEntity;
        return new UserDTO()
                .setFirstName(entity.getFirstName())
                .setLastName(entity.getLastName())
                .setLogin(entity.getLogin())
                .setPassword(entity.getPassword())
                .setCreateDate(entity.getCreateDate())
                .setUpdateDate(entity.getUpdateDate())
                .setId(entity.getId());
    }

    @Override
    public BaseEntity createEntity(BaseDTO baseDto) {
        UserDTO dto = (UserDTO) baseDto;
        return new UserEntity().setFirstName(dto.getFirstName())
                .setLastName(dto.getLastName())
                .setLogin(dto.getLogin())
                .setPassword(dto.getPassword())
                .setRole(dto.getRole())
                .setId(dto.getId())
                .setCreateDate(dto.getCreateDate())
                .setUpdateDate(dto.getUpdateDate());
    }

    @Override
    public List<BaseDTO> createDTOList(List<BaseEntity> entityList) {
        return entityList.stream().map(this::createDTO).collect(Collectors.toList());
    }

    @Override
    public List<BaseEntity> createEntityList(List<BaseDTO> dtoList) {
        return dtoList.stream().map(this::createEntity).collect(Collectors.toList());
    }
}
