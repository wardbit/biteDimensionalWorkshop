package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class blacklist {
    @TableId(value="blacklist_id",type= IdType.AUTO)
    private int blacklistId;
    @TableField(value="user_id")
    private int userId;
    @TableField(value="blocked_user_id")
    private int blockedUserId;
    @TableField(value="created_at")
    private LocalDateTime createdAt;


}
