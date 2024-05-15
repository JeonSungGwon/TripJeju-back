package com.ssafy.jeju.travelRoute.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelRoute {
    private long id;
    private long userId;
    private String routeName;
    private Timestamp createdAt;
}
