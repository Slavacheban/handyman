package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.HandymanDTO;
import com.example.handyman.entity.HandymanEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HandymanTransformer extends Transformer<HandymanEntity, HandymanDTO> {
    @Override
    public HandymanDTO createDTO(HandymanEntity entity) {
        HandymanDTO handymanDTO = new HandymanDTO();
        handymanDTO.setCreateDate(entity.getCreateDate());
        handymanDTO.setUpdateDate(entity.getUpdateDate());
        handymanDTO.setId(entity.getId());
        return handymanDTO;
    }

    @Override
    public HandymanEntity createEntity(HandymanDTO handymanDTO) {
        HandymanEntity handymanEntity = new HandymanEntity();
        handymanEntity.setCreateDate(handymanDTO.getCreateDate());
        handymanEntity.setUpdateDate(handymanDTO.getUpdateDate());
        handymanEntity.setId(handymanDTO.getId());
        return handymanEntity;
    }
}
