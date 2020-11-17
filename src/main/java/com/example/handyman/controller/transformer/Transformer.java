package com.example.handyman.controller.transformer;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Transformer<VO, DTO> {
    public abstract DTO createDTO(VO entity);
    public abstract VO createEntity(DTO dto);
    public List<DTO> createDTOList(List<VO> entityList) {
        return entityList.stream().map(this::createDTO).collect(Collectors.toList());
    }
    public List<VO> createEntityList(List<DTO> dtoList) {
        return dtoList.stream().map(this::createEntity).collect(Collectors.toList());
    }
}
