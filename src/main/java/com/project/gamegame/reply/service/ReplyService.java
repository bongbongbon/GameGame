package com.project.gamegame.reply.service;
import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.reply.domain.Reply;
import com.project.gamegame.reply.domain.ReplyRegister;
import com.project.gamegame.reply.dto.ReplyResponse;
import com.project.gamegame.reply.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    public Reply makeReply(ReplyRegister replyRegister) {
        return replyRepository.save(ReplyRegister.replyForm(replyRegister));}

    public Reply getReply(Long replyID) {
        return replyRepository.findById(replyID)
                .orElseThrow(()-> CustomException.BOARD_NOT_FOUND);}

    public Reply updateReply(Long replyID, ReplyRegister replyRegister) {
        Reply saved=replyRepository.findById(replyID)
                .orElseThrow(()->new RuntimeException("댓글 없음"));
        saved.replyUpdate(replyRegister);return saved;}

    public void deleteReply(Long replyID) {
    replyRepository.deleteByReplyID(replyID);}

    public List<ReplyResponse> getAllReplies(){
        return ReplyResponse.getAllReplies(replyRepository.findAll());}}