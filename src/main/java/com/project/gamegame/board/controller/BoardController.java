package com.project.gamegame.board.controller;
import com.project.gamegame.board.service.BoardService;
import com.project.gamegame.board.domain.Board;
import com.project.gamegame.board.domain.BoardRegister;
import com.project.gamegame.common.exception.DuplicationNameException;
import com.project.gamegame.common.response.ApiSuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/make")
    public ApiSuccessResponse<?> makeBoard(@RequestBody BoardRegister boardRegister) {
        return ApiSuccessResponse.from(boardService.makeBoard(boardRegister));
    }

    @GetMapping("/get/{boardID}")
    public ApiSuccessResponse<Board> getBoard(@PathVariable(name = "boardID") Long boardID) {
        return ApiSuccessResponse.from(boardService.getBoard(boardID));
    }

    @RequestMapping(value = "/update/{boardID}",
            method = RequestMethod.PUT, name = "updateBoard")
    public ResponseEntity<Board> updateBoard(@PathVariable("boardID") Long boardID,
                                             @RequestBody BoardRegister boardRegister) {
        try {
            Board updateBoard = boardService.updateBoard(boardID, boardRegister);
            return ResponseEntity.ok(updateBoard);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @RequestMapping(value = "/delete/{boardID}",
            method = RequestMethod.DELETE, name = "deleteBoard")
    public void deleteBoard(@PathVariable("boardID") Long boardID) {
        boardService.deleteBoard(boardID);
    }

    @RequestMapping(value = "/{boardID}/hits",
            method = RequestMethod.PUT, name = "boardHits")
    public void boardHits(@PathVariable("boardID") Long boardID) {
        boardService.boardHits(boardID);
    }

    @RequestMapping(value = "{boardID}/likes",
            method = RequestMethod.PUT, name = "boardLikes")
    public void boardLikes(@PathVariable("boardID") Long boardID) {
        boardService.boardLikes(boardID);
    }

    @RequestMapping(value = "{boardID}/cancelLikes",
            method = RequestMethod.PUT, name = "cancelBoardLikes")
    public void cancelBoardLikes(@PathVariable("boardID") Long boardID) {
        boardService.cancelBoardLikes(boardID);
    }

    @RequestMapping(value = "/{boardID}/review",
            method = RequestMethod.PUT, name = "review")
    public ResponseEntity<Board> review(@PathVariable("boardID") Long boardID,
                                        @RequestBody BoardRegister boardRegister) {
        return ResponseEntity.ok(boardService.review(boardID, boardRegister));
    }

    @RequestMapping(value = "/{boardID}/reply",
            method = RequestMethod.PUT, name = "updateBoard")
    public ResponseEntity<Board> reply(@PathVariable("boardID") Long boardID,
                                       @RequestBody BoardRegister boardRegister) {
        return ResponseEntity.ok(boardService.reply(boardID, boardRegister));
    }

    @RequestMapping("/all")
    public ResponseEntity<?> getAllBoardWritings(){
        return ResponseEntity.ok(boardService.getAllBoardWritings());
    }//[3][4][5]
}