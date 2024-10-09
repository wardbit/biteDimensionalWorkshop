package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.luntan2.entity.comments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface commentsMapper extends BaseMapper<comments> {
}
