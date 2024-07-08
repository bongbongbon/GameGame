package com.project.board_service;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Getter @MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseEntity {
    private LocalDateTime createdTime=LocalDateTime.now();
    private LocalDateTime updateTime=LocalDateTime.now();}