package com.project.gamegame.reply.controller;

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
    public ResponseEntity<?> makeReply(@RequestBody ReplyRegister replyRegister){
        return ResponseEntity.status(HttpStatus.CREATED).body(replyService.makeReply(replyRegister));}

    @GetMapping("/get/{replyID}")
    public ResponseEntity<Reply> getReply(@PathVariable(name = "replyID") Long replyID) {
        Reply reply = replyService.getReply(replyID);
        if (reply != null) {
            return ResponseEntity.ok(reply);
        }else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @RequestMapping(value = "update/{replyID}",
            method = RequestMethod.PUT,name = "updateReply")
    public ResponseEntity<Reply> updateReply(@PathVariable("replyID") Long replyID,
                                             @RequestBody ReplyRegister replyRegister){
        try{
            Reply updateReply=replyService.updateReply(replyID,replyRegister);
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