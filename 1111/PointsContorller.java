package com.example.luntan2.controllor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.luntan2.entity.points;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/points")
@MapperScan("com.example.luntan2.mapper")
public class PointsContorller {

    @Autowired
    private com.example.luntan2.mapper.pointsMapper pointsMapper;

    // 根据用户ID新增积分记录
    @PostMapping("/user/{userId}")
    public ResponseEntity<points> addPointByUserId(@PathVariable int userId, @RequestBody points point) {
        point.setUserId(userId);
        pointsMapper.insert(point);
        return new ResponseEntity<>(point, HttpStatus.CREATED);
    }

    // 根据用户ID减少积分记录（这里假设传入的Point对象中points字段为负数表示减少积分）
    @PutMapping("/user/{userId}/reduce")
    public ResponseEntity<points> reducePointByUserId(@PathVariable int userId, @RequestBody points point) {
        point.setUserId(userId);
        // 先查询当前用户的总积分
        QueryWrapper<points> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<points> pointsList = pointsMapper.selectList(queryWrapper);
        int currentPoints = pointsList.stream().mapToInt(points -> points.getPoints()).sum();

        // 判断减少积分后是否会小于0
        if (point.getPoints() < 0 && currentPoints + point.getPoints() < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        pointsMapper.updateById(point);
        return new ResponseEntity<>(point, HttpStatus.OK);
    }

    // 根据用户ID查询该用户的所有积分记录
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<points>> getPointsByUserId(@PathVariable int userId) {
        QueryWrapper<points> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        List<points> pointsList = pointsMapper.selectList(queryWrapper);
        return new ResponseEntity<>(pointsList, HttpStatus.OK);
    }

    // 根据积分记录ID删除积分记录
    @DeleteMapping("/{pointId}")
    public ResponseEntity<Void> deletePointById(@PathVariable int pointId) {
        pointsMapper.deleteById(pointId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}