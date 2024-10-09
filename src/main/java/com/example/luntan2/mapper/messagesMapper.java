package com.example.luntan2.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.example.luntan2.entity.messages;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
@Repository
@Mapper
public interface messagesMapper extends BaseMapper<messages>{
}
