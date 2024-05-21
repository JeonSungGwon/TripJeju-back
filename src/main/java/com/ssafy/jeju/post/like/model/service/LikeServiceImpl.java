package com.ssafy.jeju.post.like.model.service;

import com.ssafy.jeju.post.like.model.dto.Like;
import com.ssafy.jeju.post.like.model.mapper.LikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeMapper likeMapper;

    @Autowired
    public LikeServiceImpl(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    @Override
    public void insertLike(Like like) {
        likeMapper.insertLike(like);
    }

    @Override
    public void deleteLike(Like like) {
        likeMapper.deleteLike(like);
    }

    @Override
    public int selectLikeCountByPostId(long postId) {
        return likeMapper.selectLikeCountByPostId(postId);
    }

    @Override
    public boolean existsByUserIdAndPostId(long userId, long postId) {
        return likeMapper.existsByUserIdAndPostId(userId, postId);
    }
}
