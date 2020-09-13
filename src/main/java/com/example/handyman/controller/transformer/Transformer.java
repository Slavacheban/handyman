package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.BaseDTO;
import com.example.handyman.entity.BaseEntity;

import java.util.List;

public interface Transformer {
    BaseDTO createDTO(BaseEntity baseEntity);
    BaseEntity createEntity(BaseDTO baseDTO);
    List<BaseDTO> createDTOList(List<BaseEntity> entityList);
    List<BaseEntity> createEntityList(List<BaseDTO> dtoList);
}
