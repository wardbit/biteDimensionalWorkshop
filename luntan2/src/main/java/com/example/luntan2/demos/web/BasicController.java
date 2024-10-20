/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.luntan2.demos.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.luntan2.entity.User;
import com.example.luntan2.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import javafx.scene.canvas.GraphicsContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@MapperScan("com.example.luntan2.mapper")
@Controller
public class BasicController {
    @Autowired
    private UserMapper userMapper;


    // http://127.0.0.1:8080/hello?username=lisi
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello(User user) {
        System.out.println(user);
        return "Hello " + user.getUsername();
    }

    // http://127.0.0.1:8080/logup注册
    @RequestMapping(value = "/logup/{username}/{passwordHash}",method = RequestMethod.PUT)
    @ResponseBody
    @ApiOperation("注册")
    public User logup(@PathVariable String username,@PathVariable String passwordHash) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();

       User user = new User();
        String regex = "^[a-zA-Z]\\w{4,15}$";//账号的正则表达式,账户允许的字符为字母、数字、下划线，长度为5-16个字符
       String regex2 = "\t(?=^.{8,}$)(?=.*\\d)(?=.*\\W+)(?=.*[A-Z])(?=.*[a-z])(?!.*\\n).*$";//密码由数字/大写字母/小写字母/标点符号组成，四种都必有，8位以上
        User user1=userMapper.selectOne(updateWrapper.eq("username", username));
        if(user1!=null){
            System.out.println("账号已经存在");;
        }else{
        if (username.matches(regex)) {
            System.out.println("Username is valid.");
            user.setUsername(username);
            if (passwordHash.matches(regex2)) {
                System.out.println("Password is valid.");
             user.setPasswordHash(passwordHash);
               userMapper.insert(user);
                userMapper.insert(user);
            } else {
                System.out.println("Password is not valid.");
                System.out.println("密码由数字/大写字母/小写字母/标点符号组成，四种都必有，8位以上");}}
         else {
            System.out.println("Username is invalid.");
            System.out.println("账户允许的字符为字母、数字、下划线，长度为5-16个字符");

        }}
return user;}


        // 用户名
//        user.setPasswordHash(password_hash);// 密码
//
//        userMapper.insert(user); // 调用 insert 方法
//
//        return user;}

    // http://127.0.0.1:8080/save_user?name=newName&age=11
    @RequestMapping("/setin/{username}/{passwordHash}")
    @ResponseBody
    @ApiOperation("登录")
    public boolean setin(@PathVariable String username,@PathVariable String passwordHash) {

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", username);
        updateWrapper.eq("passwordHash", passwordHash);
        User user = userMapper.selectOne(updateWrapper);

        if(user!=null){
            System.out.println("登录成功");
            return true;
        }else{
            System.out.println("登录失败");
            return false;
        }
    }

    // http://127.0.0.1:8080/html
    @RequestMapping("/html")
    public String html(){
        return "index.html";
    }

    @ModelAttribute
    public void parseUser(@RequestParam(name = "name", defaultValue = "unknown user") String name
            , @RequestParam(name = "age", defaultValue = "12") Integer age, User user) {

    }
}
