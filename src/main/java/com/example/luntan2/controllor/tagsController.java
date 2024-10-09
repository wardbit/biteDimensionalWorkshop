package com.example.luntan2.controllor;

import com.example.luntan2.mapper.UserMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@MapperScan("com.example.luntan2.mapper")
@RestController
public class tagsController {
    @Autowired
    private UserMapper tagsMapper;
    @GetMapping("/tags")
    public String query(){
        return "tags";
    }
}
