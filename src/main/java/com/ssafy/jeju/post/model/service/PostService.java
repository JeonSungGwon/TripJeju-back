package com.ssafy.jeju.post.model.service;

import com.ssafy.jeju.post.model.dto.Post;
import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(int id);
    boolean save(Post post);
    boolean update(Post post);
    boolean delete(int id);
}
