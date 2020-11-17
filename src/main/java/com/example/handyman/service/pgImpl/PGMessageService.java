package com.example.handyman.service.pgImpl;

import com.example.handyman.dao.MessageDAO;
import com.example.handyman.entity.MessageEntity;
import com.example.handyman.service.MessageService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PGMessageService implements MessageService {
    private MessageDAO messageDAO;

    @Override
    public MessageEntity getMessageById(Long id) {
        return messageDAO.getOne(id);
    }

    @Override
    public List<MessageEntity> getMessageListByFromIdAndToId(Long fromId, Long toId) {
        return messageDAO.findAllByUserFromAndUserTo(fromId, toId);
    }
}
