package com.ssafy.jeju.comment.model.service;

import com.ssafy.jeju.comment.model.dto.Comment;
import com.ssafy.jeju.comment.model.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> findAll() {
        return commentMapper.findAll();
    }

    @Override
    public Comment findById(int id) {
        return commentMapper.findById(id);
    }

    @Override
    public List<Comment> findByPostId(int postId) {
        return commentMapper.findByPostId(postId);
    }

    @Override
    @Transactional
    public boolean save(Comment comment) {
        return commentMapper.insert(comment) > 0;
    }

    @Override
    @Transactional
    public boolean update(Comment comment) {
        return commentMapper.update(comment) > 0;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return commentMapper.delete(id) > 0;
    }
}
