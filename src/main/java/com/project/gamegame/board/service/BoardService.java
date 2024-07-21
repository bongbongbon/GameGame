package com.project.gamegame.board.service;
import com.project.gamegame.board.dto.BoardResponse;
import com.project.gamegame.board.domain.Board;
import com.project.gamegame.board.domain.BoardRegister;
import com.project.gamegame.common.exception.CustomException;
import com.project.gamegame.board.repostiory.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Board makeBoard(BoardRegister boardRegister) {
        if (boardRepository.existsByBoardName(boardRegister.getBoardName())) {
            throw CustomException.ALREADY_EXISTS;}
        return boardRepository.save(BoardRegister.boardForm(boardRegister));}

    public Board getBoard(Long boardID) {
        return boardRepository.findById(boardID)
                .orElseThrow(() -> CustomException.BOARD_NOT_FOUND);}

    public Board updateBoard(Long boardID, BoardRegister boardRegister) {
        Board saved = boardRepository.findById(boardID)
                .orElseThrow(() -> CustomException.BOARD_NOT_FOUND);
        saved.boardUpdate(boardRegister);return saved;}

    public void deleteBoard(Long boardID) {
        boardRepository.deleteByBoardID(boardID);}

    public void boardHits(Long boardID) {
        Board board = boardRepository.findById(boardID)
                .orElseThrow(() -> CustomException.BOARD_NOT_FOUND);
        board.setHits(board.getHits() + 1);boardRepository.save(board);}

    public void boardLikes(Long boardID) {
        Board board = boardRepository.findById(boardID)
                .orElseThrow(() -> CustomException.BOARD_NOT_FOUND);
        board.setLikes(board.getLikes() + 1);boardRepository.save(board);}

    public void cancelBoardLikes(Long boardID) {
        Board board = boardRepository.findById(boardID)
                .orElseThrow(() -> CustomException.BOARD_NOT_FOUND);
        long likes = board.getLikes();if (likes <= 0) {likes = 0L;}
        else {board.setLikes(likes-1);}boardRepository.save(board);}

    public List<BoardResponse> getAllBoardWritings(){
        return BoardResponse.fromEntity(boardRepository.findAll());}}