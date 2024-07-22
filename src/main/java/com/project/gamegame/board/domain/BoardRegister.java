package com.project.gamegame.board.domain;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardRegister {
    private String boardName;
    private String userName;//1]
    private String title;//[1]
    private String contents;//[1]
    private Long views;//[1]
    private Long likes;//[1]

    public static Board boardForm(BoardRegister boardRegister) {
        return Board.builder().boardName(boardRegister.getBoardName())
                .userName(boardRegister.getUserName())
                .title(boardRegister.getTitle())
                .contents(boardRegister.getContents())
                .views(boardRegister.getViews())
                .likes(boardRegister.getLikes()).build();}}