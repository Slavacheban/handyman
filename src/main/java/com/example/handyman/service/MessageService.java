package com.example.handyman.service;

import com.example.handyman.entity.MessageEntity;

import java.util.List;

public interface MessageService {
    MessageEntity getMessageById(Long id);
    List<MessageEntity> getMessageListByFromIdAndToId(Long fromId, Long toId);
}
