package com.project.gamegame.board;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardRegister {
    private String boardName;
    private String user;//1]
    private String title;//[1]
    private String contents;//[1]
    private String views;//[1]
    private String review;

    public static Board boardForm(BoardRegister boardRegister) {
        return Board.builder().boardName(boardRegister.getBoardName())
                .review(boardRegister.getReview())
                .title(boardRegister.getTitle())
                .contents(boardRegister.getContents())
                .views(boardRegister.getViews())
                .review(boardRegister.getReview()).build();}}