package com.example.luntan2.entity;

import java.time.LocalDateTime;

public class blacklist {
    private int blacklist_id;
    private int user_id;
    private int blocked_user_id;
    private LocalDateTime created_at;

    public int getBlacklist_id() {
        return blacklist_id;
    }

    public void setBlacklist_id(int blacklist_id) {
        this.blacklist_id = blacklist_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBlocked_user_id() {
        return blocked_user_id;
    }

    public void setBlocked_user_id(int blocked_user_id) {
        this.blocked_user_id = blocked_user_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "blacklist{" +
                "blacklist_id=" + blacklist_id +
                ", user_id=" + user_id +
                ", blocked_user_id=" + blocked_user_id +
                ", created_at=" + created_at +
                '}';
    }
}
