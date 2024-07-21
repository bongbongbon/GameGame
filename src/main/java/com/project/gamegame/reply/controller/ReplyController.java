package com.project.gamegame.reply.controller;
import com.project.gamegame.common.response.ApiSuccessResponse;
import com.project.gamegame.reply.domain.Reply;
import com.project.gamegame.reply.domain.ReplyRegister;
import com.project.gamegame.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/make")
    public ApiSuccessResponse<?> makeReply(@RequestBody ReplyRegister replyRegister){
        return ApiSuccessResponse.from(replyService.makeReply(replyRegister));}

    @GetMapping("/get/{replyID}")
    public ApiSuccessResponse<Reply> getReply(@PathVariable(name = "replyID") Long replyID) {
        return ApiSuccessResponse.from(replyService.getReply(replyID));}

    @RequestMapping(value = "update/{replyID}",
            method = RequestMethod.PUT,name = "updateReply")
    public ResponseEntity<Reply> updateReply(@PathVariable("replyID") Long replyID,
                                             @RequestBody ReplyRegister replyRegister){
        try{Reply updateReply=replyService.updateReply(replyID,replyRegister);
        return ResponseEntity.ok(updateReply);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @RequestMapping(value = "delete/{replyID}",
    method = RequestMethod.DELETE,name = "deleteReply")
    public void deleteReply(@PathVariable("replyID") Long replyID){
        replyService.deleteReply(replyID);}

    @RequestMapping("/all")
    public ResponseEntity<?> getAllReplies(){
        return ResponseEntity.ok(replyService.getAllReplies());}}