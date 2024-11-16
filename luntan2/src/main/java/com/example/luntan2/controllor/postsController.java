package com.example.luntan2.controllor;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.luntan2.entity.postImages;
import com.example.luntan2.entity.posts;
import com.example.luntan2.mapper.*;
import io.swagger.v3.oas.annotations.Operation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@MapperScan("com.example.luntan2.mapper")
@RestController
public class postsController {
    @Autowired
    private postsMapper mapper;
    @Autowired
    private categoriesMapper categoriesMapper;
    @Autowired
    private postImagesMapper postImagesMapper;
    @Autowired
    private FileUploadController fileUploadController;
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
    @Transactional//确保所有操作要么全部完成，要么全部回滚。
    @Operation(summary = "新建帖子")
    @PostMapping("/newposts/{userId}")
    public ResponseEntity<String> createPost(@PathVariable int userId, @RequestParam String title,
                                             @RequestParam String content,
                                             @RequestParam int categoryId,
                                             @RequestParam(required = false) MultipartFile photo,
                                              HttpServletRequest request) throws IOException {
//        System.out.println("postsMapper: " + mapper);
//        System.out.println("categoriesMapper: " + categoriesMapper);
//        System.out.println("imagesMapper: " + imagesMapper);

        if (title == null || title.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("标题不能为空或者全是空格");
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

        if (photo != null && !photo.isEmpty()) {
            if (request == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("请求对象为null，无法保存图片");
            }
            String path = request.getServletContext().getRealPath("/upload/");
            if (path == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("无法获取有效的保存路径");
            }

            String imageUrl =saveFile(photo, path);
                    updatePostUrl(newPost.getPostId(), imageUrl);

        }

        return ResponseEntity.ok("帖子创建成功");
    }

    // 验证 categoryId 是否有效的方法
    private boolean isValidCategoryId(int categoryId) {
        return categoriesMapper.selectById(categoryId) != null;
    }

    // "保存贴子的图片URL"
    public void updatePostUrl(int postsId, String imageUrl) {
        postImages images = new postImages();
        images.setPostId(postsId);
        images.setImageUrl(imageUrl);
        postImagesMapper.insert(images);
    }

    // 保存文件并返回文件的 URL 列表
    public String saveFile(MultipartFile photos, String path) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }



//            String uniqueFileName = UUID.randomUUID().toString() + "_" + photos.getOriginalFilename();
            File file = new File(path + photos.getOriginalFilename());
            photos.transferTo(file);
            String imageUrls=path + photos.getOriginalFilename(); // 保存相对路径或公开的 URL

        return imageUrls;
    }



}


