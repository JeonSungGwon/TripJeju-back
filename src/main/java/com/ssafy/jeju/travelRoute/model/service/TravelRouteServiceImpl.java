package com.ssafy.jeju.travelRoute.model.service;

import com.ssafy.jeju.travelRoute.model.dto.TravelRoute;
import com.ssafy.jeju.travelRoute.model.mapper.TravelRouteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class TravelRouteServiceImpl implements TravelRouteService {
    private final TravelRouteMapper travelRouteMapper;

    public TravelRouteServiceImpl(TravelRouteMapper travelRouteMapper) {
        this.travelRouteMapper = travelRouteMapper;
    }

    @Override
    public List<TravelRoute> findAll() {
        return travelRouteMapper.findAll();
    }

    @Override
    public TravelRoute findById(long id) {
        return travelRouteMapper.findById(id);
    }

    @Override
    public List<TravelRoute> findByUserId(long userId) {
        return travelRouteMapper.findByUserId(userId);
    }

    @Override
    @Transactional
    public boolean save(TravelRoute travelRoute) {
        return travelRouteMapper.insert(travelRoute) > 0;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return travelRouteMapper.delete(id) > 0;
    }
}
