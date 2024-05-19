package com.ssafy.jeju.visit.model.service;

import com.ssafy.jeju.favorite.model.dto.Favorite;
import com.ssafy.jeju.visit.model.dto.Visit;
import com.ssafy.jeju.visit.model.mapper.VisitMapper;

import java.util.List;

public interface VisitService {
    List<Visit> findAll();
    Visit findById(long id);
    List<Visit> findByUserId(long userId, int page, int size);
    boolean save(Visit visit);
    boolean delete(long id);
    boolean isVisit(long userId, long placeId);
    int countVisitByUser(long userId);
}
