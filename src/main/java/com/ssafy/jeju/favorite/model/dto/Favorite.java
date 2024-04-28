package com.ssafy.jeju.favorite.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Favorite {
    private Integer favoriteId;
    private Integer userId;
    private Integer placeId;
    private String code;
}