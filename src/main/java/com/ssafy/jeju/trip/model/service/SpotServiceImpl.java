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
	public List<Spot> getSpotBySpotTitle(String title, String type) {
		return spotMapper.selectSpotBySpotTitle(title, type);
	}

	@Override
	public List<Spot> getSpotBySpotTag(String tag, String type) {
		return spotMapper.selectSpotBySpotTag(tag, type);
	}

	@Override
	public List<Spot> getAllSpots() {
		return spotMapper.selectAllSpots();
	}

	
}
