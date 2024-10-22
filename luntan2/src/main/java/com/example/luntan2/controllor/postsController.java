package com.example.luntan2.controllor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.luntan2.entity.comments;
import com.example.luntan2.entity.posts;
import com.example.luntan2.mapper.*;
import io.swagger.v3.oas.annotations.Operation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@MapperScan("com.example.luntan2.mapper")
@RestController
public class postsController {
    @Autowired
    private postsMapper mapper;
    @Autowired
    private categoriesMapper categoriesMapper;
    @Operation(summary = "热门贴子,主页的帖子")
    @GetMapping("/home")
    public Page<posts> getPostsByPage(@RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        Page<posts> page = new Page<>(pageNum, pageSize);
        return  mapper.getPostsOrderByLikes(page);
    }
    @Operation(summary = "根据帖子id查询帖子")
    @GetMapping("/posts/{postId}")
    public posts getPostById(@PathVariable int postId) {
        return mapper.selectById(postId);
    }
    @Operation(summary = "新建帖子")
    @PostMapping("/newposts/{userId}")
    public ResponseEntity<String> createPost(@PathVariable int userId, @RequestParam String title,
                                             @RequestParam(required = false) String content,
                                             @RequestParam int categoryId) {
        if (title == null || title.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("标题不能为空或者全是空格");
        }
        if (content != null && content.trim().isEmpty()) {
            content = null;
        }

        // 检查 categoryId 是否有效
        if (!isValidCategoryId(categoryId)) {
            return ResponseEntity.badRequest().body("无效的分类ID");
        }

        posts newPost = new posts();
        newPost.setUserId(userId);
        newPost.setTitle(title);
        newPost.setContent(content);
        newPost.setCategoryId(categoryId); // 使用请求中提供的分类ID
        newPost.setViews(0);  // 设置初始浏览量为0

        mapper.insert(newPost);
        return ResponseEntity.ok("帖子创建成功");
    }

    // 验证 categoryId 是否有效的方法
    private boolean isValidCategoryId(int categoryId) {
        // 假设 categoriesMapper 是一个用于操作分类的 mapper
        return categoriesMapper.selectById(categoryId) != null;
    }



}


