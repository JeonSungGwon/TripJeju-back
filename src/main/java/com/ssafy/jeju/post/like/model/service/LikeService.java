package com.ssafy.jeju.post.like.model.service;

import com.ssafy.jeju.post.like.model.dto.Like;

public interface LikeService {
    // 좋아요 추가
    void insertLike(Like like);

    // 좋아요 삭제
    void deleteLike(Like like);

    // 특정 게시물의 좋아요 수 조회
    int selectLikeCountByPostId(long postId);

    // 특정 사용자가 특정 게시물에 좋아요를 눌렀는지 확인
    boolean existsByUserIdAndPostId(long userId, long postId);
}
