package com.example.luntan2.controllor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.luntan2.entity.comments;
import com.example.luntan2.entity.posts;
import com.example.luntan2.mapper.commentsMapper;
import com.example.luntan2.mapper.tagsMapper;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@MapperScan("com.example.luntan2.mapper")
@RestController
public class commentsController {

    @GetMapping("/comments")
    public String query(){
        return "comments";
    }
    @Autowired
    private commentsMapper commentsMapper;

    @Operation(summary = "查询用户id的评论")
    @GetMapping("/user/{userId}/comments")
    public Page<comments> getUserCommentsByUserId(
            @PathVariable int userId,
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize) {
        // 创建分页对象
        Page<comments> page = new Page<>(pageNum, pageSize);
        // 创建查询条件，根据 user_id 查询
        QueryWrapper<comments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        // 执行分页查询
        return commentsMapper.selectPage(page, queryWrapper);
    }
    @Operation(summary = "根据帖子id查询帖子的评论")
    @GetMapping("/posts/{postId}/comments")
    public Page<comments> getCommentsByPostId(@PathVariable int postId) {
        Page<comments> page = new Page<>(1, 10);
        QueryWrapper<comments> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("post_id", postId);
        Page<comments> resultPage = commentsMapper.selectPage(page, queryWrapper);
        return resultPage;
    }
}

