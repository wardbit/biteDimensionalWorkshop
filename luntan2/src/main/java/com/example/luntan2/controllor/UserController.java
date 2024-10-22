package com.example.luntan2.controllor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.luntan2.entity.User;
import com.example.luntan2.entity.follows;
import com.example.luntan2.entity.posts;
import com.example.luntan2.mapper.UserMapper;
import com.example.luntan2.mapper.followsMapper;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.luntan2.mapper.postsMapper;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.baomidou.mybatisplus.core.toolkit.StringPool.UTF_8;
import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@MapperScan("com.example.luntan2.mapper")
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private postsMapper postsMapper;
    @Autowired
    private followsMapper followsMapper;
    @Operation(summary = "查询所有用户")
    @GetMapping("admin/user")
    public Page<User> query(){
//      List<User> list=userMapper.selectList(null);//管理员管理用户面板
//        System.out.println(list);
//        return list;
        Page<User> page = new Page<>(1, 10);
        Page<User> userIPage = userMapper.selectPage(page, null);
        return userIPage;
    }
    @Operation(summary = "删除用户")
    @DeleteMapping("admin/user/{userId}")
    public String deleteUser(@PathVariable int userId){


        UpdateWrapper<User> deleteWrapper = new UpdateWrapper<>();
        deleteWrapper.eq("userId", userId);
        String avatarUrl = userMapper.selectById(userId).getAvatarUrl();
        if (avatarUrl!= null) {
            File file = new File(avatarUrl);
            if (file.exists()) {
                file.delete();
            }
        }
        int i=userMapper.delete(deleteWrapper);
        if(i>0){return "删除成功";}
        else{return "删除失败";}
    }
    @Operation(summary = "查询用户(用户id)")
    @GetMapping("admin/user/{userId}")
    public User queryUser(@PathVariable int userId){
        return (User) userMapper.selectById(userId);
    }
    @Operation(summary = "查询用户(用户名)")
    @GetMapping("admin/user/username/{username}")
//    @GetMapping("admin/user/{username}")
    public User queryUserByUsername(@PathVariable String username){
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        User user=new User();
        user=userMapper.selectOne(updateWrapper.eq("username", username));
        return user;
    }
    @Operation(summary = "查询用户全部贴子（分页）")
    @GetMapping("/userSearch/{userId}")
    public Map<String, Object> queryUserPosts(
            @PathVariable int userId,
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        // 分页对象
        Page<posts> page = new Page<>(pageNum, pageSize);
        // 分页查询用户的帖子
        List<posts> userPosts = postsMapper.getPostsByUserId(page, userId);

        // 获取用户信息
        List<User> users = userMapper.selectByIdForuser(userId);
        int userPostsCount = postsMapper.PostsCountByUserId(userId);
        int followingCount = followsMapper.countFollowingsByUserId(userId);
        int followersCount = followsMapper.countFollowersByUserId(userId);
        List<follows> following = followsMapper.getFollowingByUserId(userId);
        List<follows> followers = followsMapper.getFollowersByUserId(userId);

        // 构建返回数据
        Map<String, Object> result = new HashMap<>();
        result.put("userInfo", users);
        result.put("userPostsCount", userPostsCount);
        result.put("followingCount", followingCount);
        result.put("followersCount", followersCount);
        result.put("followingList", following);
        result.put("followersList", followers);
        result.put("userPosts", userPosts);
        result.put("totalPostsPages", page.getPages());
        result.put("currentPage", pageNum);
        result.put("pageSize", pageSize);

        return result;
    }

    @Operation(summary = "查询用户名的评论")
    @GetMapping("/username/{username}/comments")
    public ResponseEntity<List<Map<String, Object>>> getUserComments(@PathVariable String username) {
        List<Map<String, Object>> comments = userMapper.getUserComments(username);
        if (comments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(comments);
    }
    // 通过 nickname 查询用户及其全部言论
    @Operation(summary = "通过 nickname 查询用户及其全部言论")
    @GetMapping("/nickname/{nickname}/comments")
    public ResponseEntity<List<Map<String, Object>>> getUserCommentsByNickname(@PathVariable String nickname) throws UnsupportedEncodingException {
        // 对 nickname 进行显式解码，处理中文和特殊符号
        String decodedNickname = URLDecoder.decode(nickname, UTF_8);

        List<Map<String, Object>> comments = userMapper.getUserCommentsByNickname(decodedNickname);
        if (comments.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(comments);
    }

}

