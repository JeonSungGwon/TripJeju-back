package com.ssafy.jeju.spot.model.mapper;

import com.ssafy.jeju.spot.model.dto.Spot;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SpotMapper {
	void insertSpot(Spot spot);
	Spot selectSpotBySpotId(int spotId);
	List<Spot> selectAllSpots();
	void updateSpot(int spotId);
	void deleteSpot(int spotId);
}