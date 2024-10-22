package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class posts {
    @TableId(value="post_id",type= IdType.AUTO)
    private int postId;
    private String title;
    private String content;
    @TableField(value="user_id")
    private int userId;
    @TableField(value = "category_id")
    private int categoryId;
    private int views;
    @TableField(value="created_at")
    private LocalDateTime createdAt;
    @TableField(value="thumbnail_image")
    @Schema(description ="封面")
    private String thumbnailImage;





}
