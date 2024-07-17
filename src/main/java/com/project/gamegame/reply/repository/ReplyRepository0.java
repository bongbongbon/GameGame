package com.project.gamegame.reply.repository;
import com.project.gamegame.reply.domain.Reply0;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository public interface ReplyRepository0 extends JpaRepository<Reply0,Long> {
    void deleteByReplyID(Long replyID);}