package com.ssafy.jeju.favorite.model.mapper;

import com.ssafy.jeju.favorite.model.dto.Favorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteMapper {
    void insertFavorite(Favorite favorite);
    Favorite selectFavoriteById(int favoriteId);
    List<Favorite> selectAllFavorites();
    void updateFavorite(int favoriteId);
    void deleteFavorite(int favoriteId);
}
