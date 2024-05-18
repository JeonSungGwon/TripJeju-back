package com.ssafy.jeju.post.model.service;

import com.ssafy.jeju.post.model.dto.Post;
import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findBySpotId(int id);
    List<Post> findByUserId(int userId);
    Post findById(int id);
    void save(Post post) throws Exception;
    boolean update(Post post);
    boolean delete(int id);
}
