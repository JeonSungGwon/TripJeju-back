package com.ssafy.jeju.trip.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.jeju.trip.model.dto.Spot;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SpotMapper {
    List<Spot> selectSpotBySpotTitle(String title, String type);

    List<Spot> selectSpotBySpotTag(String tag, String type);
    List<Spot> findByIds(List<Long> placeIds);

    List<Spot> selectSpots(@Param("title") String title,
                           @Param("tag") String tag,
                           @Param("type") String type,
                           @Param("reg1") String reg1,
                           @Param("reg2") String reg2,
                           @Param("size") int size,
                           @Param("offset") int offset);

    int countSpots(@Param("title") String title,
                   @Param("tag") String tag,
                   @Param("type") String type,
                   @Param("reg1") String reg1,
                   @Param("reg2") String reg2);

    List<Spot> selectSpotBySpotMonth(String month, String type);

    List<Spot> selectAllSpots(@Param("offset") int offset, @Param("size") int size, @Param("search") String search);

	int selectAllCount(String search);
}