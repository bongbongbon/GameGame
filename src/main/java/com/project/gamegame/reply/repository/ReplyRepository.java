package com.project.gamegame.reply.repository;
import com.project.gamegame.reply.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository public interface ReplyRepository extends JpaRepository<Reply,Long> {
    boolean existsByReplyTitle(String ReplyTitle);
    void deleteByReplyID(Long replyID);}