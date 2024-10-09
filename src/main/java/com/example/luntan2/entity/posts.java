package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

public class posts {
    @TableId(value="post_id",type= IdType.AUTO)
    private int postId;
    private String title;
    private String content;
    @TableField(value="user_id")
    private int userId;
    @TableField(value = "category_id")
    private int categoryId;
    private int views;
    @TableField(value="created_at")
    private LocalDateTime createdAt;



    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    private LocalDateTime updated_at;





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "posts{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", views=" + views +
                ", createdAt=" + createdAt +
                ", updated_at=" + updated_at +
                '}';
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}
