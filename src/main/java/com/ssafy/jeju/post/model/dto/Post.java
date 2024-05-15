package com.ssafy.jeju.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private int id;
    private int boardId;
    private long spotId;
    private long userId;
    private String title;
    private String content;
    private String author;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
