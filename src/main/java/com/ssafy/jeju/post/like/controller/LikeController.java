package com.ssafy.jeju.post.like.controller;

import com.ssafy.jeju.post.like.model.dto.Like;
import com.ssafy.jeju.post.like.model.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    // 좋아요 추가
    @PostMapping("/add")
    public ResponseEntity<String> addLike(@RequestBody Like like) {
        likeService.insertLike(like);
        return ResponseEntity.status(HttpStatus.CREATED).body("Like added successfully");
    }

    // 좋아요 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteLike(@RequestBody Like like) {
        likeService.deleteLike(like);
        return ResponseEntity.ok("Like deleted successfully");
    }

    // 특정 게시물의 좋아요 수 조회
    @GetMapping("/{postId}/count")
    public ResponseEntity<Integer> getLikeCountByPostId(@PathVariable("postId") long postId) {
        int likeCount = likeService.selectLikeCountByPostId(postId);
        return ResponseEntity.ok(likeCount);
    }

    // 특정 사용자가 특정 게시물에 좋아요를 눌렀는지 확인
    @GetMapping("/exists")
    public ResponseEntity<Boolean> existsByUserIdAndPostId(
            @RequestParam("userId") long userId,
            @RequestParam("postId") long postId) {
        boolean exists = likeService.existsByUserIdAndPostId(userId, postId);
        return ResponseEntity.ok(exists);
    }
}

