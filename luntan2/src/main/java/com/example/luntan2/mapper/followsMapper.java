package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.luntan2.entity.follows;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface followsMapper extends BaseMapper<follows> {
    // 查询用户的follower数量
    @Select("select count(*) from follows where follower_id = #{userId}")
    public  int countFollowersByUserId(int userId);

    // 查询用户的following数量
    @Select("SELECT count(*) FROM follows WHERE following_id = #{userId}")
    public  int countFollowingsByUserId(int userId);
    @Select("select * from follows where following_id = #{userId}")
    public List<follows>  getFollowingByUserId(int userId);
    @Select("select * from follows where follower_id = #{userId}")
    public List<follows>  getFollowersByUserId(int userId);

}
