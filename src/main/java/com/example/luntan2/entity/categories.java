package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

public class categories {
    @TableId(type= IdType.AUTO)
    private int categories_id;
    private String name;
    private String description;
    private LocalDateTime created_at;

    public int getCategories_id() {
        return categories_id;
    }

    public void setCategories_id(int categories_id) {
        this.categories_id = categories_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "categories{" +
                "categories_id=" + categories_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
