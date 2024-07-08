package com.project.board_service;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardRegister {
    private String boardName;
    private String review;
    private String title;
    private String contents;

    public static Board boardForm(BoardRegister boardRegister){
        return Board.builder().boardName(boardRegister.getBoardName())
                .review(boardRegister.getReview())
                .title(boardRegister.getTitle())
                .contents(boardRegister.getContents()).build();}}