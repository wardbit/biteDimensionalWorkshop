package com.example.luntan2.controllor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.luntan2.entity.points;
import io.swagger.v3.oas.annotations.Operation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.luntan2.mapper.*;

import java.util.List;

@RestController
//@RequestMapping("/api/points")
@MapperScan("com.example.luntan2.mapper")
public class pointsContorller {

    @Autowired
    private pointsMapper pointsMapper;

    // 根据用户ID新增积分记录，有问题
    @Operation(summary = "根据用户ID新增积分记录")
    @PostMapping("/user/{userId}")
    public ResponseEntity<points> addPointByUserId(@PathVariable int userId, @RequestBody points point) {
        point.setUserId(userId);
        pointsMapper.insert(point);
        return new ResponseEntity<>(point, HttpStatus.CREATED);
    }

    // 根据用户ID减少积分记录（这里假设传入的Point对象中points字段为负数表示减少积分）,有问题
    @PutMapping("/user/{userId}/reduce")
    @Operation(summary = "根据用户ID减少积分记录")
    public ResponseEntity<points> reducePointByUserId(@PathVariable int userId, @RequestBody points point) {
        point.setUserId(userId);
        // 先查询当前用户的总积分
        QueryWrapper<points> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        // Bug 修复：修改 pointsMapper 为 pointsMapper
        List<points> pointsList = pointsMapper.selectList(queryWrapper);
        int currentPoints = pointsList.stream().mapToInt(points -> points.getPoints()).sum();

        // 判断减少积分后是否会小于0
        if (point.getPoints() < 0 && currentPoints + point.getPoints() < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Bug 修复：修改 pointsMapper 为 pointsMapper
        pointsMapper.updateById(point);
        return new ResponseEntity<>(point, HttpStatus.OK);
    }

    // 根据用户ID查询该用户的所有积分记录
    @GetMapping("/user/{userId}")
    @Operation(summary = "根据用户ID查询该用户的所有积分记录")
    public ResponseEntity<List<points>> getPointsByUserId(@PathVariable int userId) {
        QueryWrapper<points> queryWrapper = new QueryWrapper<>();
        // Bug 修复：删除多余的分号
        List<points> pointsList = pointsMapper.selectList(queryWrapper.eq("user_id", userId));
        return new ResponseEntity<>(pointsList, HttpStatus.OK);
    }

    // 根据积分记录ID删除积分记录


    // 根据积分记录ID删除积分记录
    @DeleteMapping("/{pointId}")
    public ResponseEntity<Void> deletePointById(@PathVariable int pointId) {
        pointsMapper.deleteById(pointId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}