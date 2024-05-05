package com.ssafy.jeju.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.jeju.trip.model.dto.Spot;

@Mapper
public interface SpotMapper {
	void insertSpot(Spot spot);
	Spot selectSpotBySpotId(int spotId);
	List<Spot> selectAllSpots();
	void updateSpot(int spotId);
	void deleteSpot(int spotId);
}