package com.ssafy.jeju.routeLike.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.jeju.routeLike.model.dto.RouteLike;
import com.ssafy.jeju.routeLike.model.mapper.RouteLikeMapper;

@Service
public class RouteLikeServiceImpl implements RouteLikeService {

    @Autowired
    private RouteLikeMapper routeLikeMapper;

    @Override
    public void insertRouteLike(RouteLike routeLike) {
        routeLikeMapper.insertRouteLike(routeLike);
    }

    @Override
    public void deleteRouteLike(Long id) {
        routeLikeMapper.deleteRouteLike(id);
    }

    @Override
    public int getCountByRouteId(Long routeId) {
        return routeLikeMapper.getCountByRouteId(routeId);
    }

    @Override
    public List<RouteLike> getLikesByUserId(Long userId) {
        return routeLikeMapper.getLikesByUserId(userId);
    }
}
