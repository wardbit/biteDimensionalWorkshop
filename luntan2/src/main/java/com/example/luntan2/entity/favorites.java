package com.example.luntan2.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

public class favorites {
    @TableField(value = "post_id")
    private int postId;
    @TableField(value = "user_id")
    private int userId;
    @TableId(value = "favorites_id",type= IdType.AUTO)
    private int favoriteId;
    @TableField(value = "created_at")
    private LocalDateTime createdAt;


}
