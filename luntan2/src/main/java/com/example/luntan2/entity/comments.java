package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class comments {
    @TableId(type= IdType.AUTO,value="comment_id")
    private String commentId;
    @TableField(value = "post_id")
    private int postId;
    @TableField(value = "user_id")
    private int userId;
    private String content;


}
