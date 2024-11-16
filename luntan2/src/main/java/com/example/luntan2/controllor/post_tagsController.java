package com.example.luntan2.controllor;

import com.example.luntan2.entity.postTags;
import com.example.luntan2.entity.tags;
import com.example.luntan2.mapper.postTagsMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@MapperScan("com.example.luntan2.mapper")
@RestController
//@RequestMapping("/api/post-tags")
public class post_tagsController {

    @Autowired
    private postTagsMapper postTagsMapper;

    // 根据post_id查询相关的tags
    @GetMapping("/{post_id}/tags")
    @Operation(summary = "根据post_id查询相关的tags")
    public ResponseEntity<List<tags>> getTagsByPostId(@PathVariable("post_id") int postId) {
        List<tags> tags = postTagsMapper.getTagsByPostId(postId);
        if (tags!= null &&!tags.isEmpty()) {
            return new ResponseEntity<>(tags, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 根据post_id新增tags
    @PostMapping("/{post_id}/tags")
    @Operation(summary = "根据post_id新增tags")
    public ResponseEntity<Void> addTagsToPost(@PathVariable("post_id") int postId, @RequestBody int tag_id) {
        postTags postTags=new postTags();
        postTags.setPostId(postId);
        postTags.setTagId(tag_id);
        int rowsInserted = postTagsMapper.insert(postTags);
        if (rowsInserted > 0) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 根据post_id删除相关的tags
    @DeleteMapping("/{post_id}/tags")
    @Operation(summary = "根据post_id删除相关的tags")
    public ResponseEntity<Void> deleteTagsByPostId(@PathVariable("post_id") int postId) {
        int rowsDeleted = postTagsMapper.deleteTagsByPostId(postId);
        if (rowsDeleted > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}