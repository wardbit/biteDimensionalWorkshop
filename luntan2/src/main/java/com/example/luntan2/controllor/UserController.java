package com.example.luntan2.controllor;

import com.example.luntan2.entity.User;
import com.example.luntan2.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@MapperScan("com.example.luntan2.mapper")
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/user")
    public List query(){
       List<User> list=userMapper.selectList(null);
        System.out.println(list);
        return list;
    }


}
