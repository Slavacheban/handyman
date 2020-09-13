package com.example.handyman.entity.listeners;

import com.example.handyman.entity.BaseEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class DateEntityListener {

    @PrePersist
    public void setCreateDate(BaseEntity entity) {
        entity.setCreateDate(new Date());
    }

    @PreUpdate
    public void setUpdateDate(BaseEntity entity) {
        entity.setUpdateDate(new Date());
    }
}
