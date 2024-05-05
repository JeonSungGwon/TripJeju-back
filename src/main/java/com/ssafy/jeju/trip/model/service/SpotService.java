package com.ssafy.jeju.trip.model.service;


import java.util.List;

import com.ssafy.jeju.trip.model.dto.Spot;

public interface SpotService {
	List<Spot> getSpotBySpotTitle(String title, String type);
	List<Spot> getSpotBySpotTag(String tag, String type);
	List<Spot> getAllSpots();
}
