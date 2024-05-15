package com.ssafy.jeju.board.model.service;

import com.ssafy.jeju.board.model.dto.Board;
import com.ssafy.jeju.board.model.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    public BoardServiceImpl(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @Override
    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    @Override
    public Board findById(int id) {
        return boardMapper.findById(id);
    }

    @Override
    @Transactional
    public boolean save(Board board) {
        return boardMapper.insert(board) > 0;
    }

    @Override
    @Transactional
    public boolean update(Board board) {
        return boardMapper.update(board) > 0;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return boardMapper.delete(id) > 0;
    }
}
