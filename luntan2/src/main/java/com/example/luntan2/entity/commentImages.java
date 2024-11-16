package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("comment_images")
public class commentImages {

    @TableId(value = "image_id",type= IdType.AUTO)
    private int imageId;
    @TableField("post_id")
    private int postId;
    @TableField("comment_id")
    private int commentId;
    @TableField("image_url")
    private String imageUrl;
    @TableField("uploaded_at")
    private String uploadedAt;

}
