package com.project.gamegame.board;
import com.project.gamegame.common.exception.DuplicationNameException;
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
        boardRepository.deleteByBoardID(boardID);}

    public void boardHits(Long boardID){
        Board board=boardRepository.findById(boardID)
 .orElseThrow(()->new BoardNotFoundException("게시판 글 없음"));
        board.setHits(board.getHits()+1);boardRepository.save(board);}

    public void boardLikes(Long boardID){
        Board board=boardRepository.findById(boardID)
.orElseThrow(()->new BoardNotFoundException("게시판 글 없음"));
        board.setLikes(board.getLikes()+1);boardRepository.save(board);}

    public void cancelBoardLikes(Long boardID){
        Board board=boardRepository.findById(boardID)
                .orElseThrow(()->new BoardNotFoundException("게시판 글 없음"));
        long likes=board.getLikes();if(likes<=0) {likes=0L;}
        else{board.setLikes(likes-1);}boardRepository.save(board);}

    public Board review(Long boardID, BoardRegister boardRegister){
        Board saved=boardRepository.findById(boardID)
                .orElseThrow(()->new RuntimeException("게시판 글 없음"));
        saved.review(boardRegister);return saved;}

    public Board reply(Long boardID, BoardRegister boardRegister){
        Board saved=boardRepository.findById(boardID)
                .orElseThrow(()->new RuntimeException("게시판 글 없음"));
        saved.reply(boardRegister);return saved;}
} //[3]