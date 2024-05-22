package com.ssafy.jeju.post.model.service;

import com.ssafy.jeju.post.like.model.mapper.LikeMapper;
import com.ssafy.jeju.post.model.dto.FileInfoDto;
import com.ssafy.jeju.post.model.dto.Post;
import com.ssafy.jeju.post.model.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostMapper postMapper;

    private final LikeMapper likeMapper;

    public PostServiceImpl(PostMapper postMapper, LikeMapper likeMapper) {
        this.postMapper = postMapper;
        this.likeMapper = likeMapper;
    }

    @Override
    public List<Post> findAll() {
        return postMapper.findAll();
    }

    @Override
    public List<Post> findBySpotId(int id) {
        List<Post> posts = postMapper.findBySpotId(id);

        // 각각의 Post 객체에 대해 좋아요 수를 조회하여 설정
        for (Post post : posts) {
            int likeCount = likeMapper.selectLikeCountByPostId(post.getId());
            post.setHeartCnt(likeCount);
        }
        return posts;
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
    public boolean update(Post post, int id) throws Exception {
        int cnt = postMapper.update(post);
        List<FileInfoDto> fileInfos = post.getFileInfos();
        if (fileInfos != null && !fileInfos.isEmpty()) {
            postMapper.deleteFile(id);
            postMapper.registerFile(post);
        }
        return cnt > 0;
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        postMapper.deleteFile(id);
        likeMapper.deletePost(id);
        return postMapper.delete(id) > 0;
    }
}
