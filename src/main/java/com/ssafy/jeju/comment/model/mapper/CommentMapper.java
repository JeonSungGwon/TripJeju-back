package com.ssafy.jeju.comment.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.jeju.comment.model.dto.Comment;
import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> findAll();
    Comment findById(int id);
    List<Comment> findByPostId(int postId);
    int insert(Comment comment);
    int update(Comment comment);
    int delete(int id);
}
