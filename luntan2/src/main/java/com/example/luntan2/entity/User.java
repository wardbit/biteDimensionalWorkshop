/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.luntan2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.yaml.snakeyaml.events.Event;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@TableName("users")
public class User {

    private String username;
    private String bio;
    private String password_hash;
    private String total_points;
    private int user_id;
    private String email;
    private String phone;
    private String avatar_url;
    private String role;
    private String created_at;
    private String last_login;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", bio='" + bio + '\'' +
                ", password_hash='" + password_hash + '\'' +
                ", total_points='" + total_points + '\'' +
                ", user_id=" + user_id +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", avatar_url='" + avatar_url + '\'' +
                ", role='" + role + '\'' +
                ", created_at='" + created_at + '\'' +
                ", last_login='" + last_login + '\'' +
                '}';
    }

    public String getTotal_points() {
        return total_points;
    }

    public void setTotal_points(String total_points) {
        this.total_points = total_points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

}
