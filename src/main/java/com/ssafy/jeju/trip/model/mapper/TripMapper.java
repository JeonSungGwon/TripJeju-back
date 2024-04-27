package com.ssafy.jeju.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.jeju.trip.model.TripDto;


@Mapper
public interface TripMapper {
	List<TripDto> selectTripSpot();
}
