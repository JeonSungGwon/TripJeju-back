package com.ssafy.jeju.trip.model.service;


import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

import com.ssafy.jeju.trip.model.dto.Spot;

public interface SpotService {

	Spot getSpotBySpotId(long id);
	List<Spot> getSpotBySpotTitle(String title, String type);
	List<Spot> getSpotBySpotTag(String tag, String type);
	Map<String, Object> getSpots(String title, String tag, String type, String reg1, String reg2, int page, int size);
	List<Spot> getSpotBySpotMonth(String month, String type);
	List<Spot> getAllSpots(int page, int size, String search);
	List<Spot> findByIds(List<Long> placeIds);
	int getAllCount(String search);
}
