package com.example.luntan2.controllor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.luntan2.entity.User;
import com.example.luntan2.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@MapperScan("com.example.luntan2.mapper")
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @ApiOperation("查询所有用户")
    @GetMapping("admin/user")
    public Page<User> query(){
//      List<User> list=userMapper.selectList(null);//管理员管理用户面板
//        System.out.println(list);
//        return list;
        Page<User> page = new Page<>(1, 10);
        Page<User> userIPage = userMapper.selectPage(page, null);
        return userIPage;
    }
    @ApiOperation("删除用户")
    @DeleteMapping("admin/user/{userId}")
    public String deleteUser(@PathVariable int userId){


        UpdateWrapper<User> deleteWrapper = new UpdateWrapper<>();
        deleteWrapper.eq("userId", userId);
        int i=userMapper.delete(deleteWrapper);
        if(i>0){return "删除成功";}
        else{return "删除失败";}
    }
    @ApiOperation("查询用户(用户id)")
    @GetMapping("admin/user/{userId}")
    public User queryUser(@PathVariable int userId){
        return userMapper.selectById(userId);
    }
    @ApiOperation("查询用户(用户名)")
//    @GetMapping("admin/user/username/{username}")
    @GetMapping("admin/user/username/{username}")
    public User queryUserByUsername(@PathVariable String username){
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        User user=new User();
        user=userMapper.selectOne(updateWrapper.eq("username", username));
        return user;
    }



}
