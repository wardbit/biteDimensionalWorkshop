package com.example.luntan2.controllor;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.luntan2.entity.User;
import com.example.luntan2.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@MapperScan("com.example.luntan2.mapper")
@RestController
@Api("文件上传接口")
public class FileUploadController {

    @Autowired
    private UserMapper userMapper;
    // 更新用户的头像URL
    @ApiOperation("更新用户的头像URL")
    @PutMapping("/upload")
    public String up(String username, MultipartFile photo, HttpServletRequest request) throws IOException {
        System.out.println(username);
        // 获取图片的原始名称
        System.out.println(photo.getOriginalFilename());
        // 取文件类型
        System.out.println(photo.getContentType());

        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo, path);

        // 更新用户的头像URL
        updateUserAvatarUrl(username, path + photo.getOriginalFilename());

        return "上传成功";
    }


    // 更新用户的头像URL
 //更新用户的头像URL
    public void updateUserAvatarUrl(String username, String avatarUrl) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("username", username); // 根据用户名查找

        User user = new User();
        user.setAvatarUrl(avatarUrl); // 设置要更新的字段

        userMapper.update(user, updateWrapper);
    }


    // 保存文件的方法
    public void saveFile(MultipartFile photo, String path) throws IOException {
        // 判断存储的目录是否存在，如果不存在则创建
        File dir = new File(path);
        if (!dir.exists()) {
            // 创建目录
            dir.mkdir();
        }

        File file = new File(path + photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
