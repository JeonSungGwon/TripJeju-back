package com.ssafy.jeju.post.model.dto;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Post {
    private int id;
    private long spotId;
    private long userId;
    private String title;
    private String content;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    private List<FileInfoDto> fileInfos;
}
