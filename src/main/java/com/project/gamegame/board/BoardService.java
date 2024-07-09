package com.project.gamegame.board;
import com.project.gamegame.DuplicationNameException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {private final BoardRepository boardRepository;
    public Board makeBoard(BoardRegister boardRegister) {
        if(boardRepository.existsByBoardName(boardRegister.getBoardName())){
            throw new DuplicationNameException("게시판 이름 이미 있음");}
        return boardRepository.save(BoardRegister.boardForm(boardRegister));}

    public Board getBoard(Long boardID) {
        return boardRepository.findById(boardID).orElse(null);}

    public Board updateBoard(Long boardID, BoardRegister boardRegister) {
        Board saved=boardRepository.findById(boardID)
                .orElseThrow(()->new RuntimeException("게시판 없음"));
        saved.boardUpdate(boardRegister);return saved;}

    public void deleteBoard(Long boardID) {
        boardRepository.deleteByBoardID(boardID);}}