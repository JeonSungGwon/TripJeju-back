package com.ssafy.jeju.travelRoute.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.jeju.travelRoute.model.dto.TravelRoute;
import java.util.List;

@Mapper
public interface TravelRouteMapper {
    List<TravelRoute> findAll();
    TravelRoute findById(long id);
    List<TravelRoute> findByUserId(long userId);
    int insert(TravelRoute travelRoute);
    int delete(long id);
}
