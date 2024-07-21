package com.project.gamegame.reply.domain;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyRegister {
    private Long userID;
    private Long boardID;
    private String contents;
    private String reReply;

    public static Reply replyForm(ReplyRegister replyRegister){
        return Reply.builder().userID(replyRegister.getUserID())
                .boardID(replyRegister.getBoardID())
                .contents(replyRegister.getContents())
                .reReply(replyRegister.getReReply()).build();}}