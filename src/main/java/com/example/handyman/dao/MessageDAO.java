package com.example.handyman.dao;

import com.example.handyman.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageDAO extends JpaRepository<MessageEntity, Long> {
    @Query("SELECT m FROM message m WHERE m.user_from_id = fromId AND m.user_to_id = toId")
    List<MessageEntity> findAllByUserFromAndUserTo(Long fromId, Long toId);
}
