package com.ssafy.jeju.board.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.jeju.board.model.dto.Board;
import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> findAll();
    Board findById(int id);
    int insert(Board board);
    int update(Board board);
    int delete(int id);
}