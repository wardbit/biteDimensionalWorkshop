package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.luntan2.entity.comments;
import com.example.luntan2.entity.posts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface postsMapper extends BaseMapper<posts> {
    @Select("SELECT * FROM posts WHERE user_id = #{userId}")
    List<posts> getPostsByUserId(Page<posts> page, @Param("userId") int userId);

    @Select("select count(*) from posts where user_id = #{userId}")
     int PostsCountByUserId(int userId);
    @Select("SELECT posts.*, COUNT(likes.post_id) AS like_count " +
            "FROM posts LEFT JOIN likes ON posts.post_id = likes.post_id " +
            "GROUP BY posts.post_id " +
            "ORDER BY like_count DESC")
     Page<posts> getPostsOrderByLikes(Page<?> page);




}
