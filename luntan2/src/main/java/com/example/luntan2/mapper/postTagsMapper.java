package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.luntan2.entity.postTags;
import com.example.luntan2.entity.tags;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface postTagsMapper extends BaseMapper<postTags> {

    // 根据post_id查询相关的tags
    @Select("SELECT t.* FROM tags t " +
            "JOIN post_tags pt ON t.tag_id = pt.tag_id " +
            "WHERE pt.post_id = #{post_id}")
    List<tags> getTagsByPostId(@Param("post_id") int postId);

    // 根据post_id新增tags
    @Insert("<script>" +
            "INSERT INTO post_tags (post_id, tag_id) VALUES " +
            "<foreach item='tag' collection='tags' open='' close='' separator=','>" +
            "(#{post_id}, #{tag.tag_id})" +
            "</foreach>" +
            "</script>")
    int addTagsToPost(@Param("post_id") int postId, @Param("tags") List<tags> tags);

    // 根据post_id删除相关的tags
    @Delete("DELETE FROM post_tags WHERE post_id = #{post_id}")
    int deleteTagsByPostId(@Param("post_id") int postId);
}
