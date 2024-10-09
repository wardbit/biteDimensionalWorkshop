package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class likes {
    @TableId(value="like_id",type= IdType.AUTO)
    private int likeId;
    private int user_id;
    private int post_id;
    private int comment_id;
    private LocalDateTime created_at;


}
