package com.ssafy.jeju.post.like.model.dto;

import lombok.*;

@Data
public class Like {
    private Long id;
    private Long userId;
    private Integer postId;
}
