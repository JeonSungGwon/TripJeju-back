package com.ssafy.jeju.routeLike.model.service;

import java.util.List;

import com.ssafy.jeju.routeLike.model.dto.RouteLike;

public interface RouteLikeService {
    void insertRouteLike(RouteLike routeLike);
    void deleteRouteLike(Long id);
    int getCountByRouteId(Long routeId);
    List<RouteLike> getLikesByUserId(Long userId);
}
