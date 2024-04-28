package com.ssafy.jeju.favorite.model.service;

import com.ssafy.jeju.favorite.model.dto.Favorite;
import com.ssafy.jeju.favorite.model.mapper.FavoriteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteMapper favoriteMapper;

    @Override
    public void createFavorite(Favorite favorite) {
        favoriteMapper.insertFavorite(favorite);
    }

    @Override
    public Favorite getFavoriteById(int favoriteId) {
        return favoriteMapper.selectFavoriteById(favoriteId);
    }

    @Override
    public List<Favorite> getAllFavorites() {
        return favoriteMapper.selectAllFavorites();
    }

    @Override
    public void updateFavorite(int favoriteId) {
        favoriteMapper.updateFavorite(favoriteId);
    }

    @Override
    public void deleteFavorite(int favoriteId) {
        favoriteMapper.deleteFavorite(favoriteId);
    }
}
