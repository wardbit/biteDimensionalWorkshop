package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class comments {
    private String comment_id;
    @TableId(type= IdType.AUTO)
    private int post_id;
    private int user_id;
    private String content;

    @Override
    public String toString() {
        return "comments{" +
                "comment_id='" + comment_id + '\'' +
                ", post_id=" + post_id +
                ", user_id=" + user_id +
                ", content='" + content + '\'' +
                '}';
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
