package com.ssafy.jeju.board.model.service;

import com.ssafy.jeju.board.model.dto.Board;
import java.util.List;

public interface BoardService {
    List<Board> findAll();
    Board findById(int id);
    boolean save(Board board);
    boolean update(Board board);
    boolean delete(int id);
}