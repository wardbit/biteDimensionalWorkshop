package com.example.luntan2.controllor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@MapperScan("com.example.luntan2.mapper")
@RestController
public class postsController {
    @PostMapping("/posts")
    public String posts(){
        return "posts success";
    }
}