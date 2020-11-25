package com.example.handyman.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "handyman")
@NoArgsConstructor
@AllArgsConstructor
public class HandymanEntity extends BaseEntity {
    @OneToOne
    private UserEntity user;
}
