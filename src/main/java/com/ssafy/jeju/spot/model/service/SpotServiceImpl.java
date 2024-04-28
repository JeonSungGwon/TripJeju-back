package com.ssafy.jeju.spot.model.service;

import com.ssafy.jeju.spot.model.dto.Spot;
import com.ssafy.jeju.spot.model.mapper.SpotMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
