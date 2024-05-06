package com.ssafy.jeju.comment.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int id;
    private Integer parentId; // 부모 댓글 ID, nullable
    private int postId;
    private long userId;
    private String content;
    private String author;
    private Timestamp createdAt;
}
