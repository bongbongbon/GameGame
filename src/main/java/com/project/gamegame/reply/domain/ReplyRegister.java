package com.project.gamegame.reply.domain;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyRegister {
    private String replyTitle;
    private Long userID;
    private Long boardID;
    private String contents;

    public static Reply replyForm(ReplyRegister replyRegister){
        return Reply.builder().replyTitle(replyRegister.getReplyTitle())
                .userID(replyRegister.getUserID())
                .boardID(replyRegister.getBoardID())
                .contents(replyRegister.getContents()).build();}}