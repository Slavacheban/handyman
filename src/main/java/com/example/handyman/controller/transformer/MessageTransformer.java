package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.BaseDTO;
import com.example.handyman.controller.dto.MessageDTO;
import com.example.handyman.entity.BaseEntity;
import com.example.handyman.entity.MessageEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessageTransformer implements Transformer {
    @Override
    public BaseEntity createEntity(BaseDTO baseDto) {
        MessageDTO dto = (MessageDTO) baseDto;
        return new MessageEntity()
                .setFromUserId(dto.getFromUserId())
                .setToUserId(dto.getToUserId())
                .setContent(dto.getContent())
                .setEdited(dto.isEdited())
                .setId(dto.getId())
                .setUpdateDate(dto.getUpdateDate())
                .setCreateDate(dto.getCreateDate());
    }

    @Override
    public BaseDTO createDTO(BaseEntity baseEntity) {
        MessageEntity entity = (MessageEntity) baseEntity;
        return new MessageDTO()
                .setFromUserId(entity.getFromUserId())
                .setToUserId(entity.getToUserId())
                .setContent(entity.getContent())
                .setEdited(entity.isEdited())
                .setUpdateDate(entity.getUpdateDate())
                .setCreateDate(entity.getCreateDate())
                .setId(entity.getId());
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
