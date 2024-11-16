package com.example.luntan2.controllor;

import com.example.luntan2.entity.tags;
import com.example.luntan2.mapper.tagsMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@MapperScan("com.example.luntan2.mapper")
@RestController
@RequestMapping("/api/tags")
public class tagsController {

    @Autowired
    private tagsMapper tagsMapper;

    // 增加一个新的标签
    @PostMapping
    public ResponseEntity<Void> addTag(@RequestBody tags tag) {
        int rowsInserted = tagsMapper.insertTag(tag.getName());
        if (rowsInserted > 0) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 根据tag_id删除一个标签
    @DeleteMapping("/{tag_id}")
    public ResponseEntity<Void> deleteTagById(@PathVariable("tag_id") int tagId) {
        // 先查询要删除的标签是否存在（可根据实际需求决定是否添加此验证步骤）
        tags tag = tagsMapper.getTagById(tagId);
        if (tag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int rowsDeleted = tagsMapper.deleteTagById(tagId);
        if (rowsDeleted > 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
