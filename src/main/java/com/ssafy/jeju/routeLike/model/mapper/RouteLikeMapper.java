package com.ssafy.jeju.routeLike.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.jeju.routeLike.model.dto.RouteLike;

@Mapper
public interface RouteLikeMapper {
    void insertRouteLike(RouteLike routeLike);
    void deleteRouteLike(Long id);
    int getCountByRouteId(Long routeId);
    List<RouteLike> getLikesByUserId(Long userId);
}
