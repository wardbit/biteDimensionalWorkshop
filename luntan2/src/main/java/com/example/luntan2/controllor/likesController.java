package com.example.luntan2.controllor;

import com.example.luntan2.mapper.likesMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@MapperScan("com.example.luntan2.mapper")
@RestController
public class likesController {
    @GetMapping("/likes")
    public String query(){
        return "likes";
    }
    @Autowired
    public likesMapper likesMapper;

}
