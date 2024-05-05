package com.ssafy.jeju.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.jeju.trip.model.dto.Spot;

@Mapper
public interface SpotMapper {
	List<Spot> selectSpotBySpotTitle(String title, String type);
	List<Spot> selectSpotBySpotTag(String tag, String type);
	List<Spot> selectAllSpots();
}