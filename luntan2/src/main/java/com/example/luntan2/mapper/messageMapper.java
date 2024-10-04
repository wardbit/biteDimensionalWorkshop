package com.example.luntan2.mapper;
import com.example.luntan2.entity.message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface messageMapper extends BeanMapper<message>{
}
