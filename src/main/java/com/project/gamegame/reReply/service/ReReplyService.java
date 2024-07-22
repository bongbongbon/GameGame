package com.project.gamegame.reReply.service;
import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.reReply.domain.ReReply;
import com.project.gamegame.reReply.domain.ReReplyRegister;
import com.project.gamegame.reReply.dto.ReReplyResponse;
import com.project.gamegame.reReply.repository.ReReplyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReReplyService {
    private final ReReplyRepository reReplyRepository;

    public ReReply makeReReply(ReReplyRegister reReplyRegister) {
        if(reReplyRepository.existsByReReplyTitle(reReplyRegister.getReReplyTitle())){
            throw CustomException.ALREADY_EXISTS;}
        return reReplyRepository.save(ReReplyRegister.reReplyForm(reReplyRegister));}

    public ReReply getReReply(Long reReplyID) {
        return reReplyRepository.findById(reReplyID)
                .orElseThrow(()->CustomException.BOARD_NOT_FOUND);}

    public ReReply updateReReply(Long reReplyID, ReReplyRegister reReplyRegister) {
        ReReply saved=reReplyRepository.findById(reReplyID)
                .orElseThrow(()-> CustomException.BOARD_NOT_FOUND);
    saved.reReplyUpdate(reReplyRegister);return saved;}

    public void deleteReReply(Long reReplyID) {
        reReplyRepository.deleteByReReplyID(reReplyID);}

    public List<ReReplyResponse> getAllReReplies() {
        return ReReplyResponse.getAllReReplies(reReplyRepository.findAll());}}