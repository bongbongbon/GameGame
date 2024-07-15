package com.project.gamegame.board;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

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
    private String views;//[1]

    private String review="";
    private String reply="";
    private Long hits;//[1]
    private Long likes;//[1]

    public static Board boardForm(BoardRegister boardRegister) {
        return Board.builder().boardName(boardRegister.getBoardName())
                .userName(boardRegister.getUserName())
                .title(boardRegister.getTitle())
                .contents(boardRegister.getContents())
                .views(boardRegister.getViews())

                .review(boardRegister.getReview())
                .reply(boardRegister.getReply())
                .hits(boardRegister.getHits())
                .likes(boardRegister.getLikes()).build();
    }

}