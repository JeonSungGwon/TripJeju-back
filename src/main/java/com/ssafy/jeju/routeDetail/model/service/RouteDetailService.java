package com.ssafy.jeju.routeDetail.model.service;

import com.ssafy.jeju.routeDetail.model.dto.RouteDetail;
import java.util.List;

public interface RouteDetailService {
    List<RouteDetail> findAll();
    RouteDetail findById(long id);
    List<RouteDetail> findByRouteId(long routeId);
    boolean save(RouteDetail routeDetail);
    boolean update(RouteDetail routeDetail);
    boolean delete(long id);
}
