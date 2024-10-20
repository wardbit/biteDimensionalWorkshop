package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class likes {
    @TableId(value="like_id",type= IdType.AUTO)
    private int likeId;
    @TableField(value="user_id")
    private int userId;
    @TableField(value="post_id")
    private int postId;
    @TableField(value="comment_id")
    private int commentId;
    @TableField(value="created_at")
    private LocalDateTime createdAt;


}
