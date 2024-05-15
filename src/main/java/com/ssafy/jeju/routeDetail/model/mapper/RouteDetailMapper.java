package com.ssafy.jeju.routeDetail.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.jeju.routeDetail.model.dto.RouteDetail;
import java.util.List;

@Mapper
public interface RouteDetailMapper {
    List<RouteDetail> findAll();
    RouteDetail findById(long id);
    List<RouteDetail> findByRouteId(long routeId);
    int insert(RouteDetail routeDetail);
    int update(RouteDetail routeDetail);
    int delete(long id);
}
