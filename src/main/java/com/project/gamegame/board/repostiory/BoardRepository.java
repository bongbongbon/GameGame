package com.project.gamegame.board.repostiory;
import com.project.gamegame.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository public interface BoardRepository extends JpaRepository<Board,Long>{
    boolean existsByBoardName(String boardName);
    void deleteByBoardID(Long boardID);}