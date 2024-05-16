package com.ssafy.jeju.favorite.model.service;

import com.ssafy.jeju.favorite.model.dto.Favorite;
import java.util.List;

public interface FavoriteService {
    List<Favorite> findAll();
    Favorite findById(long id);
    List<Favorite> findByUserId(long userId);
    boolean save(Favorite favorite);
    boolean delete(long id);
    boolean isFavorite(long userId, long placeId);
}
