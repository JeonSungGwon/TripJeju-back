package com.ssafy.jeju.visit.model.mapper;

import com.ssafy.jeju.visit.model.dto.Visit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VisitMapper {
    List<Visit> findAll();
    Visit findById(long id);
    List<Visit> findByUserId(long userId, int offset, int size);
    int insert(Visit visit);
    int delete(long id);
    int countVisitByUserAndPlace(long userId, long placeId);
    int countVisitByUser(long userId);
}
