package com.ssafy.jeju.trip.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.jeju.trip.model.TripDto;
import com.ssafy.jeju.trip.model.mapper.TripMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {
	private final TripMapper tripMapper;
	
	@Override
	public List<TripDto> selectTripSpot() {
		return tripMapper.selectTripSpot();
	}
	
	
}
