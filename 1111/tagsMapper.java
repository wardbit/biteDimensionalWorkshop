package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.luntan2.entity.tags;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface tagsMapper extends BaseMapper<tags>{
    // 插入一个新的标签
    @Insert("INSERT INTO tags (name) VALUES (#{name})")
    int insertTag(@Param("name") String name);

    // 根据tag_id删除标签
    @Delete("DELETE FROM tags WHERE tag_id = #{tag_id}")
    int deleteTagById(@Param("tag_id") int tagId);

    // 根据tag_id查询标签信息（可根据实际需求添加，用于验证删除等操作是否成功）
    @Select("SELECT * FROM tags WHERE tag_id = #{tag_id}")
    tags getTagById(@Param("tag_id") int tagId);
}


