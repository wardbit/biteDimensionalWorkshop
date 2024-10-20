package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("post_tags")
public class postTags {
    @TableId(value = "post_id")
    private String postId;
    @TableField(value = "tag_id")
    private String tagId;

    @Override
    public String toString() {
        return "postTags{" +
                "postId='" + postId + '\'' +
                ", tagId='" + tagId + '\'' +
                '}';
    }



    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
