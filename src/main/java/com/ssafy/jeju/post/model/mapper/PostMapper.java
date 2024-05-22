package com.ssafy.jeju.post.model.mapper;

import com.ssafy.jeju.post.model.dto.FileInfoDto;
import org.apache.ibatis.annotations.Mapper;
import com.ssafy.jeju.post.model.dto.Post;
import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAll();
    List<Post> findBySpotId(int id);
    List<Post> findByUserId(int userId);
    Post findById(int id);
    int insert(Post post);
    int update(Post post);
    int delete(int id);
    int deleteFile(int postId);
    void registerFile(Post post) throws Exception;
    void updateFile(Post post) throws Exception;
    List<FileInfoDto> fileInfoList(int articleNo) throws Exception;
}
