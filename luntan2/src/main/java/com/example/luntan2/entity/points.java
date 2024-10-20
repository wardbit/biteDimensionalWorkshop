package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

public class points {
    @TableId(value="point_id",type= IdType.AUTO)
    private int pointId;
    @TableField("user_id")
    private int userId;
    private int points;

    @Override
    public String toString() {
        return "points{" +
                "pointId=" + pointId +
                ", userId=" + userId +
                ", points=" + points +
                ", actionType='" + actionType + '\'' +
                ", created_at=" + created_at +
                '}';
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public int getPointId() {
        return pointId;
    }

    public void setPointId(int pointId) {
        this.pointId = pointId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    @TableField("action_type")
    private String actionType;

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    private LocalDateTime created_at;



    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }




}
