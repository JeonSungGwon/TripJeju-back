package com.ssafy.jeju.post.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.jeju.post.model.dto.Post;
import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll();
    Post findById(int id);
    int insert(Post post);
    int update(Post post);
    int delete(int id);
}
