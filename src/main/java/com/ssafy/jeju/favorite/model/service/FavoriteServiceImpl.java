package com.ssafy.jeju.favorite.model.service;

import com.ssafy.jeju.favorite.model.dto.Favorite;
import com.ssafy.jeju.favorite.model.mapper.FavoriteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteMapper favoriteMapper;

    public FavoriteServiceImpl(FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }

    @Override
    public List<Favorite> findAll() {
        return favoriteMapper.findAll();
    }

    @Override
    public Favorite findById(long id) {
        return favoriteMapper.findById(id);
    }

    @Override
    public List<Favorite> findByUserId(long userId) {
        return favoriteMapper.findByUserId(userId);
    }

    @Override
    @Transactional
    public boolean save(Favorite favorite) {
        return favoriteMapper.insert(favorite) > 0;
    }

    @Override
    @Transactional
    public boolean delete(long id) {
        return favoriteMapper.delete(id) > 0;
    }
}
