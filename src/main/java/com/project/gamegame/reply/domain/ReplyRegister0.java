package com.project.gamegame.reply.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyRegister0 {
    private Long userID;
    private Long boardID;
    private String content;
    private String reReply;

    public static Reply0 replyForm(ReplyRegister0 replyRegister){
        return Reply0.builder().userID(replyRegister.getUserID())
                .boardID(replyRegister.getBoardID())
                .content(replyRegister.getContent())
                .reReply(replyRegister.getReReply()).build();}}