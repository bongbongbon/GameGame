package com.project.gamegame.reReply.controller;
import com.project.gamegame.common.response.ApiSuccessResponse;
import com.project.gamegame.reReply.domain.ReReply;
import com.project.gamegame.reReply.domain.ReReplyRegister;
import com.project.gamegame.reReply.service.ReReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reReply")
@RequiredArgsConstructor
public class ReReplyController {
    private final ReReplyService reReplyService;

     @PostMapping("/make")
    public ApiSuccessResponse<?> makeReReply(@RequestBody ReReplyRegister reReplyRegister){
        return ApiSuccessResponse.from(reReplyService.makeReReply(reReplyRegister));}

    @GetMapping("/get/{reReplyID}")
    public ApiSuccessResponse<ReReply> getReReply
            (@PathVariable(name = "reReplyID") Long reReplyID){
        return ApiSuccessResponse.from(reReplyService.getReReply(reReplyID));}

    @RequestMapping(value = "update/{reReplyID}",
            method = RequestMethod.PUT,name = "updateReReply")
    public ResponseEntity<ReReply> updateReReply(@PathVariable("reReplyID") Long reReplyID,
                                                 @RequestBody ReReplyRegister reReplyRegister){
        try {ReReply updateReReply=reReplyService.updateReReply(reReplyID,reReplyRegister);
        return ResponseEntity.ok(updateReReply);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @RequestMapping(value = "delete/{reReplyID}",
    method = RequestMethod.DELETE,name = "deleteReReply")
    public void deleteReReply(@PathVariable("reReplyID") Long reReplyID){
        reReplyService.deleteReReply(reReplyID);}

    @RequestMapping("/all")
    public ResponseEntity<?> getAllReReplies(){
        return ResponseEntity.ok(reReplyService.getAllReReplies());}}