package com.ssafy.jeju.board.controller;

import com.ssafy.jeju.board.model.dto.Board;
import com.ssafy.jeju.board.model.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {
        return ResponseEntity.ok(boardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoardById(@PathVariable int id) {
        Board board = boardService.findById(id);
        return board != null ? ResponseEntity.ok(board) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        if (boardService.save(board)) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable int id, @RequestBody Board board) {
        board.setId(id);
        if (boardService.update(board)) {
            return ResponseEntity.ok(board);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable int id) {
        if (boardService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
