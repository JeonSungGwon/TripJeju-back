package com.ssafy.jeju.visit.model.service;

import com.ssafy.jeju.favorite.model.mapper.FavoriteMapper;
import com.ssafy.jeju.visit.model.dto.Visit;
import com.ssafy.jeju.visit.model.mapper.VisitMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    private final VisitMapper visitMapper;

    public VisitServiceImpl(VisitMapper visitMapper) {
        this.visitMapper = visitMapper;
    }

    @Override
    public List<Visit> findAll() {
        return visitMapper.findAll();
    }

    @Override
    public Visit findById(long id) {
        return visitMapper.findById(id);
    }

    @Override
    public List<Visit> findByUserId(long userId, int page, int size) {
        int offset = page * size;
        return visitMapper.findByUserId(userId, offset, size);
    }

    @Override
    public boolean save(Visit visit) {
        return visitMapper.insert(visit) > 0;
    }

    @Override
    public boolean delete(long id) {
        return visitMapper.delete(id) > 0;
    }

    @Override
    public boolean isVisit(long userId, long placeId) {
        int count = visitMapper.countVisitByUserAndPlace(userId, placeId);
        return count > 0;
    }

    @Override
    public int countVisitByUser(long userId) {
        return visitMapper.countVisitByUser(userId);
    }
}
