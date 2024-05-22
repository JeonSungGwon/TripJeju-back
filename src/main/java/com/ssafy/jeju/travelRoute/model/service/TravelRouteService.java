package com.ssafy.jeju.travelRoute.model.service;

import com.ssafy.jeju.travelRoute.model.dto.TravelRoute;
import java.util.List;

public interface TravelRouteService {
    List<TravelRoute> findAll(String search, int page, int size);
    TravelRoute findById(long id);
    List<TravelRoute> findByUserId(long userId);
    long count(String search);
    boolean save(TravelRoute travelRoute);
    boolean delete(long id);
}
