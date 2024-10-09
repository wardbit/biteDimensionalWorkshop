package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.luntan2.entity.user_drive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface user_driveMapper extends BaseMapper<user_drive> {
}
