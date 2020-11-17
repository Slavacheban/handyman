package com.example.handyman.controller.transformer;

import com.example.handyman.controller.dto.MessageDTO;
import com.example.handyman.entity.MessageEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class MessageTransformer extends Transformer<MessageEntity, MessageDTO> {
    private UserTransformer userTransformer;

    @Override
    public MessageEntity createEntity(MessageDTO dto) {
        MessageEntity entity = new MessageEntity();
        entity.setId(dto.getId());
        entity.setFromUser(userTransformer.createEntity(dto.getFromUser()));
        entity.setToUser(userTransformer.createEntity(dto.getToUser()));
        entity.setContent(dto.getContent());
        entity.setEdited(dto.isEdited());
        entity.setUpdateDate(dto.getUpdateDate());
        entity.setCreateDate(dto.getCreateDate());
        return entity;
    }

    @Override
    public MessageDTO createDTO(MessageEntity entity) {
        MessageDTO dto = new MessageDTO();
        dto.setId(entity.getId());
        dto.setFromUser(userTransformer.createDTO(entity.getFromUser()));
        dto.setToUser(userTransformer.createDTO(entity.getToUser()));
        dto.setContent(entity.getContent());
        dto.setEdited(entity.isEdited());
        dto.setUpdateDate(entity.getUpdateDate());
        dto.setCreateDate(entity.getCreateDate());
        return dto;
    }
}
