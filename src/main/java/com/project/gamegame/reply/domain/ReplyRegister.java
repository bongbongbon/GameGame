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
    private String content;
    private String reReply;

    public static Reply replyForm(ReplyRegister replyRegister){
        return Reply.builder().userID(replyRegister.getUserID())
                .boardID(replyRegister.getBoardID())
                .content(replyRegister.getContent())
                .reReply(replyRegister.getReReply()).build();}}