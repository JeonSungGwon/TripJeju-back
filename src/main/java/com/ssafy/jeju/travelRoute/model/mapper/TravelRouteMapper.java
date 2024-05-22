package com.ssafy.jeju.travelRoute.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ssafy.jeju.travelRoute.model.dto.TravelRoute;
import java.util.List;

@Mapper
public interface TravelRouteMapper {
    List<TravelRoute> findAll(@Param("search") String search, @Param("offset") int offset, @Param("size") int size);
    TravelRoute findById(long id);
    List<TravelRoute> findByUserId(long userId);
    long count(@Param("search") String search);
    int insert(TravelRoute travelRoute);
    int delete(long id);
}
