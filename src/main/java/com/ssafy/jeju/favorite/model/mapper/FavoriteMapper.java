package com.ssafy.jeju.favorite.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.jeju.favorite.model.dto.Favorite;
import java.util.List;

@Mapper
public interface FavoriteMapper {
    List<Favorite> findAll();
    Favorite findById(long id);
    List<Favorite> findByUserId(long userId);
    int insert(Favorite favorite);
    int delete(long id);
}
