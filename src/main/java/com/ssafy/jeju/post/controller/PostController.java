package com.ssafy.jeju.post.controller;

import com.ssafy.jeju.post.model.dto.FileInfoDto;
import com.ssafy.jeju.post.model.dto.Post;
import com.ssafy.jeju.post.model.mapper.PostMapper;
import com.ssafy.jeju.post.model.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/post")
public class PostController {
    @Value("${file.path}")
    private String uploadPath;

    @Value("${file.path.upload-images}")
    private String uploadImagePath;

    @Value("${file.path.upload-files}")
    private String uploadFilePath;
    private final PostService postService;
    private final PostMapper postMapper;

    public PostController(PostService postService, PostMapper postMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        Post post = postService.findById(id);
        System.out.println(post);
        return ResponseEntity.ok(post);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(postService.findByUserId(userId));
    }

    @GetMapping("/spot/{spotId}")
    public ResponseEntity<List<Post>> getPostByPostId(@PathVariable int spotId) {
        return ResponseEntity.ok(postService.findBySpotId(spotId));
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestPart("post") Post post, @RequestParam(value = "upfile", required = false) MultipartFile[] files) throws Exception{

        if (files != null) {
//			String realPath = servletContext.getRealPath(UPLOAD_PATH);
//			String realPath = servletContext.getRealPath("/resources/img");
            String today = new SimpleDateFormat("yyMMdd").format(new Date());
            String saveFolder = uploadPath + File.separator + today;
            log.debug("저장 폴더 : {}", saveFolder);
            File folder = new File(saveFolder);
            if (!folder.exists())
                folder.mkdirs();
            List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
            for (MultipartFile mfile : files) {
                FileInfoDto fileInfoDto = new FileInfoDto();
                String originalFileName = mfile.getOriginalFilename();
                if (!originalFileName.isEmpty()) {
                    String saveFileName = UUID.randomUUID().toString()
                            + originalFileName.substring(originalFileName.lastIndexOf('.'));
                    fileInfoDto.setSaveFolder(today);
                    fileInfoDto.setOriginalFile(originalFileName);
                    fileInfoDto.setSaveFile(saveFileName);
                    log.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", mfile.getOriginalFilename(), saveFileName);
                    mfile.transferTo(new File(folder, saveFileName));
                }
                fileInfos.add(fileInfoDto);
            }
            post.setFileInfos(fileInfos);
        }
            postService.save(post);
            return ResponseEntity.ok(post);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestPart("post") Post post, @RequestParam(value = "upfile", required = false) MultipartFile[] files) throws Exception{

        System.out.println(post.getFileInfos());
        post.setId(id);
        post.setFileInfos(postMapper.fileInfoList(id));
        if (postService.update(post,id)) {
            return ResponseEntity.ok(post);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable int id) {
        if (postService.delete(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
