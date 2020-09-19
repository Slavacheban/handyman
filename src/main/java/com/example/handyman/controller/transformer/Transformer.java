package com.example.handyman.controller.transformer;

import java.util.List;

public interface Transformer<VO, DTO> {
    DTO createDTO(VO baseEntity);
    VO createEntity(DTO baseDTO);
    List<DTO> createDTOList(List<VO> entityList);
    List<VO> createEntityList(List<DTO> dtoList);
}
