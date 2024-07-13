package com.project.gamegame.board;
import com.project.gamegame.common.exception.DuplicationNameException;
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
    public ResponseEntity<?> makeBoard(@RequestBody BoardRegister boardRegister){
        try{Board board=boardService.makeBoard(boardRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(board);}
        catch(DuplicationNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}

    /* @GetMapping("/get/{boardID}")
    public ResponseEntity<Board> getBoard(@PathVariable Long boardID){
        Board board=boardService.getBoard(boardID);
        if(board!=null){return ResponseEntity.ok(board);
        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}*/

    @RequestMapping(value = "/get/{boardID}",method = RequestMethod.GET,name = "getBoard")
    public ResponseEntity<Board> getBoard(@PathVariable("boardID") Long boardID){
        Board board=boardService.getBoard(boardID);
        if(board!=null){return ResponseEntity.ok(board);
        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @RequestMapping(value = "/update/{boardID}",method = RequestMethod.PUT,name = "updateBoard")
    public ResponseEntity<Board> updateBoard(@PathVariable("boardID") Long boardID,
                                             @RequestBody BoardRegister boardRegister){
        try {Board updateBoard=boardService.updateBoard(boardID,boardRegister);
            return ResponseEntity.ok(updateBoard);}
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @RequestMapping(value = "/delete/{boardID}",
            method = RequestMethod.DELETE,name = "deleteBoard")
    public void deleteBoard(@PathVariable("boardID") Long boardID){
        boardService.deleteBoard(boardID);}

    @RequestMapping(value = "/{boardID}/hits",
            method = RequestMethod.PUT,name = "boardHits")
    public void boardHits(@PathVariable("boardID") Long boardID){
        boardService.boardHits(boardID);}}//[3]