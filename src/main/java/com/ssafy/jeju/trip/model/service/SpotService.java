package com.ssafy.jeju.trip.model.service;


import java.util.List;

import com.ssafy.jeju.trip.model.dto.Spot;

public interface SpotService {
	void createSpot(Spot spot);
	Spot getSpotBySpotId(int spotId);
	List<Spot> getAllSpots();
	void updateSpot(int spotId);
	void deleteSpot(int spotId);
}
