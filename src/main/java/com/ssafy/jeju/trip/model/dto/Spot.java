package com.ssafy.jeju.trip.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Spot {
    private Long id;
    private String title;
    private String address;
    private String roadAddress;
    private String introduction;
    private String allTag;
    private String tag;
    private String reg1;
    private String reg2;
    private String type;
    private Double latitude;
    private Double longitude;
    private String phoneNumber;
    private String imgPath;
    private String thumbnailPath;

    
}   