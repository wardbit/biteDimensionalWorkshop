package com.example.luntan2.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.luntan2.entity.points;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface pointsMapper extends BaseMapper<pointsMapper> {
    void updateById(points point);

    void insert(points point);

    List<points> selectList(QueryWrapper<points> queryWrapper);
}
