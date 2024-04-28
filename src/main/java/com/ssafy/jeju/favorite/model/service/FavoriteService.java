package com.ssafy.jeju.favorite.model.service;

import com.ssafy.jeju.favorite.model.dto.Favorite;

import java.util.List;

public interface FavoriteService {
    void createFavorite(Favorite favorite);
    Favorite getFavoriteById(int favoriteId);
    List<Favorite> getAllFavorites();
    void updateFavorite(Favorite favorite);
    void deleteFavorite(int favoriteId);
}
