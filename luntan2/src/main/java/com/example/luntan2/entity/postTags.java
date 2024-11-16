package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("post_tags")
public class postTags {
    @TableId(value = "post_id")
    private int postId;
    @TableField(value = "tag_id")
    private int tagId;


}
