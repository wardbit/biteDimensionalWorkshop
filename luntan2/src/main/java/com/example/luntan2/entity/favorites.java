package com.example.luntan2.entity;


public class favorites {
    private int post_id;
    private int user_id;
    private int favorite_id;
    private String created_at;

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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
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
