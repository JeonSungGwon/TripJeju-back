package com.ssafy.jeju.trip.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.jeju.trip.model.dto.Spot;
import com.ssafy.jeju.trip.model.mapper.SpotMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpotServiceImpl implements SpotService {

	private final SpotMapper spotMapper;

	@Override
	public Spot getSpotBySpotId(long id) {
		return spotMapper.selectSpotBySpotId(id);
	}
	@Override
	public List<Spot> getSpotBySpotTitle(String title, String type) {
		return spotMapper.selectSpotBySpotTitle(title, type);
	}
	@Override
	public List<Spot> getSpotBySpotMonth(String month, String type) {
		return spotMapper.selectSpotBySpotMonth(month, type);
	}
	@Override
	public Map<String, Object> getSpots(String title, String tag, String type, String reg1, String reg2, int page, int size) {
		int offset = page * size;
		List<Spot> spots = spotMapper.selectSpots(title, tag, type, reg1, reg2, size, offset);
		int total = spotMapper.countSpots(title, tag, type, reg1, reg2);

		Map<String, Object> result = new HashMap<>();
		result.put("spots", spots);
		result.put("total", total);
		return result;
	}

	@Override
	public List<Spot> getSpotBySpotTag(String tag, String type) {
		return spotMapper.selectSpotBySpotTag(tag, type);
	}

	@Override
	public List<Spot> getAllSpots(int page, int size, String search) {
		int offset = page * size;
		return spotMapper.selectAllSpots(offset, size, search);
	}

	@Override
	public List<Spot> findByIds(List<Long> placeIds) {
		return spotMapper.findByIds(placeIds);
	}


	@Override
	public int getAllCount(String search) {
		return spotMapper.selectAllCount(search);
	}


}
