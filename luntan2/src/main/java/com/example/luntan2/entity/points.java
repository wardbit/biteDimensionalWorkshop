package com.example.luntan2.entity;

public class points {
    private int point_id;
    private int user_id;
    private int points;
    private String action_type;
    private String created_at;

    public int getPoint_id() {
        return point_id;
    }

    public void setPoint_id(int point_id) {
        this.point_id = point_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "points{" +
                "point_id=" + point_id +
                ", user_id=" + user_id +
                ", points=" + points +
                ", action_type='" + action_type + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
