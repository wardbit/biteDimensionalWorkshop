package com.example.luntan2.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

public class favorites {
    private int post_id;
    private int user_id;
    @TableId(type= IdType.AUTO)
    private int favorite_id;
    private LocalDateTime created_at;

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

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "favorites{" +
                "post_id=" + post_id +
                ", user_id=" + user_id +
                ", favorite_id=" + favorite_id +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
