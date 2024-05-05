package com.ssafy.jeju.trip.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spot {
    private int spotId;
    private String title;
    private String address;
    private String roadAddress;
    private String introduction;
    private String tags;
    private double latitude;
    private double longitude;
    private String code;
    private String phoneNumber;
    private String imgPath;
    
}   