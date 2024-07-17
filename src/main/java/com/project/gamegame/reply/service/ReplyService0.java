package com.project.gamegame.reply.service;

import com.project.gamegame.reply.domain.Reply0;
import com.project.gamegame.reply.domain.ReplyRegister0;
import com.project.gamegame.reply.dto.ReplyResponse0;
import com.project.gamegame.reply.repository.ReplyRepository0;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService0 {
    private final ReplyRepository0 replyRepository;
    public Object makeReply(ReplyRegister0 replyRegister) {
        return replyRepository.save(ReplyRegister0.replyForm(replyRegister));}

    public Reply0 getReply(Long replyID) {
        return replyRepository.findById(replyID).orElse(null);}

    public Reply0 updateReply(Long replyID, ReplyRegister0 replyRegister) {
        Reply0 saved=replyRepository.findById(replyID)
                .orElseThrow(()->new RuntimeException("댓글 없음"));
        saved.replyUpdate(replyRegister);return saved;}

    public void deleteReply(Long replyID) {
    replyRepository.deleteByReplyID(replyID);}

    public List<ReplyResponse0> getAllReplies(){
        return ReplyResponse0.getAll(replyRepository.findAll());}}