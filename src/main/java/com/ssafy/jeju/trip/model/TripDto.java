package com.ssafy.jeju.trip.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TripDto {
    private int spotId;
    private String title;
    private String address;
    private String roadAddress;
    private String introduction;
    private String tags;
    private double latitude;
    private double longitude;
    private String phoneNumber;
    private String imagePath;
    
	public TripDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TripDto(int spotId, String title, String address, String roadAddress, String introduction, String tags,
			double latitude, double longitude, String phoneNumber, String imagePath) {
		super();
		this.spotId = spotId;
		this.title = title;
		this.address = address;
		this.roadAddress = roadAddress;
		this.introduction = introduction;
		this.tags = tags;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phoneNumber = phoneNumber;
		this.imagePath = imagePath;
	}

    
}   