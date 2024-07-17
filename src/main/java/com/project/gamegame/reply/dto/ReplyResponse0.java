package com.project.gamegame.reply.dto;

import com.project.gamegame.reply.domain.Reply0;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyResponse0 {
    private Long userID;
    private Long boardID;
    private String content;
    private String reReply;

    public static ReplyResponse0 replyResponse(Reply0 reply){
        return ReplyResponse0.builder()
                .userID(reply.getUserID())
                .boardID(reply.getBoardID())
                .content(reply.getContent())
                .reReply(reply.getReReply()).build();}

    public static List<ReplyResponse0> getAll(List<Reply0> replyList){
        return replyList.stream()
                .map(ReplyResponse0::replyResponse)
                .collect(Collectors.toList());}}