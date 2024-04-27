package com.ssafy.jeju.trip.model.service;

import java.util.List;

import com.ssafy.jeju.trip.model.TripDto;

public interface TripService {
	List<TripDto> selectTripSpot();
}
