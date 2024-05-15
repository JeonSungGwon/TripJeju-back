package com.ssafy.jeju.comment.model.service;

import com.ssafy.jeju.comment.model.dto.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment findById(int id);
    List<Comment> findByPostId(int postId);
    boolean save(Comment comment);
    boolean update(Comment comment);
    boolean delete(int id);
}
