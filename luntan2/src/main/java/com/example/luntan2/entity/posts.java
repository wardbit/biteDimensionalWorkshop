package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableField(exist = false)
    private long favoritesCount;
    @TableField(exist = false)
    private int commentCount ;
    @TableField(exist = false)
    private List<comments> commentsList;
    // 标签
    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private int tagId;
    @TableField(exist = false)
    private int likeCount;
    @TableField(exist = false)
    private String categoryName;





}
