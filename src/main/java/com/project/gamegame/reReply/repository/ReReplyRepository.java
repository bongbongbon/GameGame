package com.project.gamegame.reReply.repository;
import com.project.gamegame.reReply.domain.ReReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository public interface ReReplyRepository extends JpaRepository<ReReply,Long> {
    void deleteByReReplyID(Long reReplyID);}