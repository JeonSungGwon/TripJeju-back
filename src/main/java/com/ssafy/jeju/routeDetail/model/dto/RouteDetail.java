package com.ssafy.jeju.routeDetail.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDetail {
    private long id;
    private long routeId;
    private long placeId;
    private int sequence;
}
