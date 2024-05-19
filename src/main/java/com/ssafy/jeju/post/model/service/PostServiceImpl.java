package com.ssafy.jeju.post.model.service;

import com.ssafy.jeju.post.model.dto.FileInfoDto;
import com.ssafy.jeju.post.model.dto.Post;
import com.ssafy.jeju.post.model.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;

    public PostServiceImpl(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<Post> findAll() {
        return postMapper.findAll();
    }

    @Override
    public List<Post> findBySpotId(int id) {
        return postMapper.findBySpotId(id);
    }

    @Override
    public List<Post> findByUserId(int userId) {
        return postMapper.findByUserId(userId);
    }

    @Override
    public Post findById(int id) {
        return postMapper.findById(id);
    }



    @Override
    @Transactional
    public void save(Post post) throws Exception{
        postMapper.insert(post);

        List<FileInfoDto> fileInfos = post.getFileInfos();
        if (fileInfos != null && !fileInfos.isEmpty()) {
            postMapper.registerFile(post);
        }
    }

    @Override
    @Transactional
    public boolean update(Post post) {
        return postMapper.update(post) > 0;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        postMapper.deleteFile(id);
        return postMapper.delete(id) > 0;
    }
}
