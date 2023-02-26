package com.example.goodnight.global.entity;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@EntityListeners(value = {AuditingEntityListener.class})
@MappedSuperclass
public abstract class BaseEntity {
    @CreatedDate private LocalDateTime createdAt;

    @LastModifiedDate private LocalDateTime updatedDate;
}