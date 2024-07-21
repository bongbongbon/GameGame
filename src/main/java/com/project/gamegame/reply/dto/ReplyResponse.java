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
    private String contents;
    private String reReply;

    public static ReplyResponse replyResponse(Reply reply){
        return ReplyResponse.builder()
                .userID(reply.getUserID())
                .boardID(reply.getBoardID())
                .contents(reply.getContents())
                .reReply(reply.getReReply()).build();}

    public static List<ReplyResponse> getAllReplies(List<Reply> replyList){
        return replyList.stream()
                .map(ReplyResponse::replyResponse)
                .collect(Collectors.toList());}}