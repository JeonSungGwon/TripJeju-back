package com.ssafy.jeju.favorite.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    private long id;
    private long placeId;
    private long userId;
    private Timestamp createdAt;
}
