package com.example.luntan2.controllor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@MapperScan("com.example.luntan2.mapper")
@RestController
public class post_tagsController {
    @GetMapping("/post_tags")
    public String query(){
        return "post_tags";
    }
}
