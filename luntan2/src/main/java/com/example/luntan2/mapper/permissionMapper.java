package com.example.luntan2.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.luntan2.entity.permissions;

@Mapper
@Repository
public interface permissionMapper extends BaseMapper<permissions> {
}
