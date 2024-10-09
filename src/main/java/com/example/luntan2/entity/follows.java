package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class follows {
    @TableId(type= IdType.AUTO)
    private int follow_id;
    private String follower_id;
    private String following_id;
    private LocalDateTime created_at;

    public int getFollow_id() {
        return follow_id;
    }

    public void setFollow_id(int follow_id) {
        this.follow_id = follow_id;
    }

    public String getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(String follower_id) {
        this.follower_id = follower_id;
    }

    public String getFollowing_id() {
        return following_id;
    }

    public void setFollowing_id(String following_id) {
        this.following_id = following_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "follows{" +
                "follow_id=" + follow_id +
                ", follower_id='" + follower_id + '\'' +
                ", following_id='" + following_id + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
