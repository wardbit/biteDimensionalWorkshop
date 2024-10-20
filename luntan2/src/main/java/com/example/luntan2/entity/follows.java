package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class follows {
    @TableId(type= IdType.AUTO,value = "follow_id")
    private int followId;
    @TableField(value = "follower_id")
    private String followerId;
    @TableField(value = "following_id")
    private String followingId;
    @TableField(value = "created_at")
    private LocalDateTime createdAt;


}
