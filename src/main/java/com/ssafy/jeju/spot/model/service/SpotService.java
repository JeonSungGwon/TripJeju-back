package com.ssafy.jeju.spot.model.service;

import com.ssafy.jeju.spot.model.dto.Spot;

import java.util.List;

public interface SpotService {
	void createSpot(Spot spot);
	Spot getSpotBySpotId(int spotId);
	List<Spot> getAllSpots();
	void updateSpot(Spot spot);
	void deleteSpot(int spotId);
}
