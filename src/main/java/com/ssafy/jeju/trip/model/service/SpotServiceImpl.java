package com.ssafy.jeju.trip.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.jeju.trip.model.dto.Spot;
import com.ssafy.jeju.trip.model.mapper.SpotMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService {

	private final SpotMapper spotMapper;

	@Override
	public void createSpot(Spot spot) {
		spotMapper.insertSpot(spot);
	}

	@Override
	public Spot getSpotBySpotId(int spotId) {
		return spotMapper.selectSpotBySpotId(spotId);
	}

	@Override
	public List<Spot> getAllSpots() {
		return spotMapper.selectAllSpots();
	}

	@Override
	public void updateSpot(int spotId) {
		spotMapper.updateSpot(spotId);
	}

	@Override
	public void deleteSpot(int spotId) {
		spotMapper.deleteSpot(spotId);
	}
}
