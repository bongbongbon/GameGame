package com.project.board_service;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import javax.swing.text.html.parser.Entity;
@Builder
//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseEntity{@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long boardID;public String boardName;
    private String review;
    private String title;//[1]
    private String contents;//[1]

    public void boardUpdate(BoardRegister boardRegister){
        this.boardName=boardRegister.getBoardName();
        this.review=boardRegister.getReview();
        this.title=boardRegister.getTitle();
        this.contents=boardRegister.getContents();}}