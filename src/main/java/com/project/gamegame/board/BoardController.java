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
    @PostMapping
    public ResponseEntity<?> makeBoard(@RequestBody BoardRegister boardRegister){
        try{Board board=boardService.makeBoard(boardRegister);
            return ResponseEntity.status(HttpStatus.CREATED).body(board);}
        catch(DuplicationNameException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());}}

    @GetMapping("/get/{boardID}")
    public ResponseEntity<Board> getBoard(@PathVariable Long boardID){
        Board board=boardService.getBoard(boardID);
        if(board!=null){return ResponseEntity.ok(board);
        } else {return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);}}

    @PutMapping("/update/{boardID}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long boardID,
                                             @RequestBody BoardRegister boardRegister){
        try {Board updateBoard=boardService.updateBoard(boardID,boardRegister);
            return ResponseEntity.ok(updateBoard);}
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);}}

    @DeleteMapping("/delete/{boardID}")
    public void deleteBoard(@PathVariable Long boardID){
        boardService.deleteBoard(boardID);}

    @PatchMapping("/{boardID}/hits")
    public void boardHits(@PathVariable Long boardID){
        boardService.boardHits(boardID);}}//[3]