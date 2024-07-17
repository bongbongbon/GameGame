package com.project.gamegame.reply.controller;

import com.project.gamegame.reply.domain.Reply0;
import com.project.gamegame.reply.domain.ReplyRegister0;
import com.project.gamegame.reply.service.ReplyService0;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController0 {
    private final ReplyService0 replyService;

    @PostMapping("/make")
    public ResponseEntity<?> makeReply(@RequestBody ReplyRegister0 replyRegister){
        return ResponseEntity.status(HttpStatus.CREATED).body(replyService.makeReply(replyRegister));}

    @GetMapping("/get/{replyID}")
    public ResponseEntity<Reply0> getReply(@PathVariable(name = "replyID") Long replyID) {
        Reply0 reply = replyService.getReply(replyID);
        if (reply != null) {
            return ResponseEntity.ok(reply);
        }else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @RequestMapping(value = "update/{replyID}",
            method = RequestMethod.PUT,name = "updateReply")
    public ResponseEntity<Reply0> updateReply(@PathVariable("replyID") Long replyID,
                                              @RequestBody ReplyRegister0 replyRegister){
        try{
            Reply0 updateReply=replyService.updateReply(replyID,replyRegister);
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