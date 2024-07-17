package com.project.gamegame.reply.dto;

import com.project.gamegame.reply.domain.Reply;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyResponse {
    private Long userID;
    private Long boardID;
    private String content;
    private String reReply;

    public static ReplyResponse replyResponse(Reply reply){
        return ReplyResponse.builder()
                .userID(reply.getUserID())
                .boardID(reply.getBoardID())
                .content(reply.getContent())
                .reReply(reply.getReReply()).build();}

    public static List<ReplyResponse> getAll(List<Reply> replyList){
        return replyList.stream()
                .map(ReplyResponse::replyResponse)
                .collect(Collectors.toList());}}