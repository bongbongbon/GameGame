package com.project.gamegame.reReply.dto;
import com.project.gamegame.reReply.domain.ReReply;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReReplyResponse {
    private Long replyID;
    private String reReplyTitle;
    private Long userID;
    private Long boardID;
    private String contents;

    public static ReReplyResponse reReplyResponse(ReReply reReply){
        return ReReplyResponse.builder()
                .reReplyTitle(reReply.getReReplyTitle())
                .replyID(reReply.getReReplyID())
                .userID(reReply.getUserID())
                .boardID(reReply.getBoardID())
                .contents(reReply.getContents()).build();}

    public static List<ReReplyResponse> getAllReReplies(List<ReReply> reReplyList){
        return reReplyList.stream()
                .map(ReReplyResponse::reReplyResponse)
                .collect(Collectors.toList());}}