package com.ssafy.jeju.visit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visit {
    private Long id;
    private Long placeId;
    private Long userId;
    private Date visitDate;
    private Timestamp createdAt;
}
