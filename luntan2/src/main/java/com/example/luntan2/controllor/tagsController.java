package com.example.luntan2.controllor;

import com.example.luntan2.mapper.UserMapper;
import com.example.luntan2.mapper.tagsMapper;
//import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@MapperScan("com.example.luntan2.mapper")
@RestController
public class tagsController {
    @Autowired
    private tagsMapper mapper;
//    @ApiOperation("查询所有标签")
    @GetMapping("/tags")
    public String query(){
        return "tags";
    }
}
