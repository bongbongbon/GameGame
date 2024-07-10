package com.project.gamegame.board;
import com.project.gamegame.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Board extends BaseEntity {@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long boardID;
    private String boardName;
    private String user;//[1]
    private String title;//[1]
    private String contents;//[1]
    private String views;//[1]
    private String review;

    public void boardUpdate(BoardRegister boardRegister){
        this.boardName=boardRegister.getBoardName();
        this.user=boardRegister.getUser();
        this.title=boardRegister.getTitle();
        this.contents=boardRegister.getContents();
        this.views=boardRegister.getViews();
        this.review=boardRegister.getReview();}}