package com.project.gamegame.board;


import com.project.gamegame.quiz.controller.question.response.SubjectiveQuestionResponse;
import com.project.gamegame.quiz.domain.SubjectiveQuestion;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardResponse {
    private String boardName;
    private String userName;//1]
    private String title;//[1]
    private String contents;//[1]
    private String views;//[1]

    private String review="";
    private String reply="";
    private Long hits;//[1]
    private Long likes;//[1]

    public static BoardResponse fromEntity(Board board) {
        return BoardResponse.builder()
                .boardName(board.getBoardName())
                .userName(board.getUserName())
                .title(board.getTitle())
                .contents(board.getContents())
                .views(board.getViews())
                .review(board.getReview())
                .reply(board.getReply())
                .hits(board.getHits())
                .likes(board.getLikes())
                .build();
    }

    public static List<BoardResponse> fromEntity(List<Board> boardList){
        return boardList.stream()
                .map(BoardResponse::fromEntity)
                .collect(Collectors.toList());
    }

}
