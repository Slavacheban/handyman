package com.example.handyman.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "handyman")
@NoArgsConstructor
@AllArgsConstructor
public class HandymanEntity extends BaseEntity {

    @Fetch(FetchMode.JOIN)
    @OneToOne
    private UserEntity user;
}
