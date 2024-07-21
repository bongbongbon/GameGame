package com.project.gamegame.reply.domain;
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
public class Reply extends BaseEntity {@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyID;
    private Long userID;
    private Long boardID;
    private String contents;
    private String reReply;

    public void replyUpdate(ReplyRegister replyRegister){
        this.userID=replyRegister.getUserID();
        this.boardID=replyRegister.getBoardID();
        this.contents =replyRegister.getContents();
        this.reReply=replyRegister.getReReply();}}