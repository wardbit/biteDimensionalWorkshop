package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.luntan2.entity.blacklist;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface blackListMapper extends BaseMapper<blacklist> {
}
