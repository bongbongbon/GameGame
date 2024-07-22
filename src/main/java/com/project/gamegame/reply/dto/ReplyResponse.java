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
    private String replyTitle;
    private Long userID;
    private Long boardID;
    private String contents;

    public static ReplyResponse replyResponse(Reply reply){
        return ReplyResponse.builder()
                .replyTitle(reply.getReplyTitle())
                .userID(reply.getUserID())
                .boardID(reply.getBoardID())
                .contents(reply.getContents()).build();}

    public static List<ReplyResponse> getAllReplies(List<Reply> replyList){
        return replyList.stream()
                .map(ReplyResponse::replyResponse)
                .collect(Collectors.toList());}}