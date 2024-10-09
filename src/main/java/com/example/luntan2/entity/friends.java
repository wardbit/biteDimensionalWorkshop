package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class friends {
    @TableId(type= IdType.AUTO)
    private int friends_id;
    private int user1_id;
    private int user2_id;
    private String friends_name;

    public int getFriends_id() {
        return friends_id;
    }

    public void setFriends_id(int friends_id) {
        this.friends_id = friends_id;
    }

    public int getUser1_id() {
        return user1_id;
    }

    public void setUser1_id(int user1_id) {
        this.user1_id = user1_id;
    }

    public int getUser2_id() {
        return user2_id;
    }

    public void setUser2_id(int user2_id) {
        this.user2_id = user2_id;
    }

    public String getFriends_name() {
        return friends_name;
    }

    public void setFriends_name(String friends_name) {
        this.friends_name = friends_name;
    }

    @Override
    public String toString() {
        return "friends{" +
                "friends_id=" + friends_id +
                ", user1_id=" + user1_id +
                ", user2_id=" + user2_id +
                ", friends_name='" + friends_name + '\'' +
                '}';
    }
}
