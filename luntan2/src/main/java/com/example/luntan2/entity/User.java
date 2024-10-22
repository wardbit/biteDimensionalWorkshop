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

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Data
@TableName("users")
public class User {

    /**
     * 用户名
     */
    private String username;
    /**
     * 用户简介
     */
    private String bio;
    /**
     * 密码哈希值
     */
    @TableField("password_hash")
    private String passwordHash;
    /**
     * 总积分
     */
    @TableField("total_points")
    private String totalPoints;
    /**
     * 用户ID
     */
    @TableId(value = "user_id",type= IdType.AUTO)
    private int userId;
    /**
     * 电子邮件
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 头像URL
     */
    @TableField("avatar_url")
    private String avatarUrl;
    /**
     * 用户角色
     */
    private String role;
    /**
     * 创建时间
     */
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;
    /**
     * 最后登录时间
     */
    @TableField(value = "last_login",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime lastLogin;
    /**
     * 昵称
     */
    private String nickname;





}
