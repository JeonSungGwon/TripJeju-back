package com.ssafy.jeju.routeDetail.model.service;

import com.ssafy.jeju.routeDetail.model.dto.RouteDetail;
import com.ssafy.jeju.routeDetail.model.mapper.RouteDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RouteDetailServiceImpl implements RouteDetailService {
    private final RouteDetailMapper routeDetailMapper;

    public RouteDetailServiceImpl(RouteDetailMapper routeDetailMapper) {
        this.routeDetailMapper = routeDetailMapper;
    }

    @Override
    public List<RouteDetail> findAll() {
        return routeDetailMapper.findAll();
    }

    @Override
    public RouteDetail findById(long id) {
        return routeDetailMapper.findById(id);
    }

    @Override
    public List<RouteDetail> findByRouteId(long routeId) {
        return routeDetailMapper.findByRouteId(routeId);
    }

    @Override
    @Transactional
    public boolean save(RouteDetail routeDetail) {
        return routeDetailMapper.insert(routeDetail) > 0;
    }

    @Override
    @Transactional
    public boolean update(RouteDetail routeDetail) {
        return routeDetailMapper.update(routeDetail) > 0;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return routeDetailMapper.delete(id) > 0;
    }
}
