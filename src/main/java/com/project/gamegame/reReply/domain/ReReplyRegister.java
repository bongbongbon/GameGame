package com.project.gamegame.reReply.domain;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReReplyRegister {
    private Long replyID;
    private String reReplyTitle;
    private Long userID;
    private Long boardID;
    private String contents;

    public static ReReply reReplyForm(ReReplyRegister reReplyRegister){
        return ReReply.builder().replyID(reReplyRegister.getReplyID())
                .reReplyTitle(reReplyRegister.getReReplyTitle())
                .userID(reReplyRegister.getUserID())
                .boardID(reReplyRegister.getBoardID())
                .contents(reReplyRegister.getContents()).build();}}