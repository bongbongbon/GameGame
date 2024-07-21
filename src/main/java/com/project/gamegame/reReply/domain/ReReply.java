package com.project.gamegame.reReply.domain;
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
public class ReReply extends BaseEntity {@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reReplyID;
    private Long replyID;
    private Long userID;
    private Long boardID;
    private String contents;

    public void reReplyUpdate(ReReplyRegister reReplyRegister){
        this.replyID=reReplyRegister.getReplyID();
        this.userID=reReplyRegister.getUserID();
        this.boardID=reReplyRegister.getBoardID();
        this.contents=reReplyRegister.getContents();}}