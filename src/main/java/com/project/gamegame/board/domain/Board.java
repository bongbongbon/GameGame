package com.project.gamegame.board.domain;
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
public class Board extends BaseEntity { @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long boardID;
    private String boardName;
    private String userName;//[1]
    private String title;//[1]
    private String contents;//[1]

    private Long hits;//[1]
    private Long likes;//[1]

    public void boardUpdate(BoardRegister boardRegister){
        this.boardName=boardRegister.getBoardName();
        this.userName =boardRegister.getUserName();
        this.title=boardRegister.getTitle();
        this.contents=boardRegister.getContents();

        this.hits=boardRegister.getHits();
        this.likes=boardRegister.getLikes();}}