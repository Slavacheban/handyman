package com.example.handyman.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "message")
public class MessageEntity extends BaseEntity {
    @Column(name = "from_user_id")
    private Long fromUserId;
    @Column(name = "to_user_id")
    private Long toUserId;
    @Column(name = "is_edited")
    private boolean isEdited;
    @Column(name = "content")
    private String content;
}
