package com.ssafy.jeju.routeLike.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteLike {
    private Long id;
    private Long routeId;
    private Long userId;
}
