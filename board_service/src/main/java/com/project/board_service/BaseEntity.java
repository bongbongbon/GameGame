package com.project.board_service;
import lombok.Getter;
import java.time.LocalDateTime;
@Getter
public class BaseEntity {
    private LocalDateTime createdTime=LocalDateTime.now();
    private LocalDateTime updateTime=LocalDateTime.now();}