package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.luntan2.entity.User;
//import io.swagger.annotations.ApiModelProperty;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
    // 用户查询用户页面结果
    @Schema(description ="用户查询用户页面结果")
    @Select("select nickname,username,avatar_url from users where user_id=#{userId}")
    @Result(column = "username", property = "username")
    @Result(column = "nickname", property = "nickname")
    @Result(column = "avatar_url", property = "avatarUrl")
    List<User> selectByIdForuser(@Param("userId") Integer userId);
    // 查询用户名及其所有评论
//    @ApiModelProperty("查询用户名及其所有评论")
    @Select("SELECT u.username, c.content, c.created_at FROM users u " +
            "JOIN comments c ON u.user_id = c.user_id " +
            "WHERE u.username = #{username}")
    List<Map<String, Object>> getUserComments(@Param("username") String username);
    // 通过 user_id 查询用户及其所有评论
//    @ApiOperation("通过 user_id 查询用户及其所有评论")
//    @Select("SELECT u.username, c.content, c.created_at FROM users u " +
//            "JOIN comments c ON u.user_id = c.user_id " +
//            "WHERE u.user_id = #{userId}")
//    List<Map<String, Object>> getUserCommentsByUserId(@Param("userId") int userId);
    // 通过 nickname 查询用户及其所有评论
//    @ApiModelProperty("通过 nickname 查询用户及其所有评论")
    @Select("SELECT u.username, c.content, c.created_at FROM users u " +
            "JOIN comments c ON u.user_id = c.user_id " +
            "WHERE u.nickname = #{nickname}")
    List<Map<String, Object>> getUserCommentsByNickname(@Param("nickname") String nickname);
}

