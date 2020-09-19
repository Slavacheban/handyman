package com.example.handyman.dao;

import com.example.handyman.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageDAO extends JpaRepository<MessageEntity, Long> {
    @Query(value = "SELECT * FROM handyman.message WHERE from_user_id = :fromId AND to_user_id = :toId", nativeQuery = true)
    List<MessageEntity> findAllByUserFromAndUserTo(@Param("fromId") Long fromId, @Param("toId") Long toId);
}
