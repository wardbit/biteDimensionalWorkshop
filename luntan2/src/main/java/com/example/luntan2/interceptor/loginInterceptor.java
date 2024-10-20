package com.example.luntan2.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.luntan2.entity.User;
import com.example.luntan2.mapper.UserMapper;
import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@MapperScan("com.example.luntan2.mapper")
@Api("注册拦截器")
@RestController
public class loginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor");
        String username = request.getHeader("username");
        String password = request.getHeader("passwordHash");
        if (isValidUsername(username) && isValidPassword(password)) {
            return true; // 用户名和密码有效，继续处理请求
        } else {
            // 用户名或密码无效，返回错误响应
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Invalid username or password");
            return false; // 阻止请求继续处理
        }
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 在请求处理之后执行，可以用于处理视图渲染等
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 在整个请求完成后执行，无论请求是否成功，都可以用于清理资源等
    }
    private boolean isValidUsername(String username) {
        // 这里可以定义你的用户名验证逻辑，例如长度、字符集等
        String regex = "^[a-zA-Z]\\w{4,15}$";
        QueryWrapper<User> updateWrapper = new QueryWrapper<>();
        User user1=userMapper.selectOne(updateWrapper.eq("username", username));
        if(user1==null){
            throw new IllegalArgumentException("Username already exists");
            }
        if (username.matches(regex)) {
            return true;
        }
        else {
            System.out.println("账户允许的字符为字母、数字、下划线，长度为5-16个字符");
            return false;
        }
    }
    private boolean isValidPassword(String password) {
        // 这里可以定义你的密码验证逻辑，例如长度、字符集、是否包含特殊字符等
        String regex = "\t(?=^.{8,}$)(?=.*\\d)(?=.*\\W+)(?=.*[A-Z])(?=.*[a-z])(?!.*\\n).*$";
        if (password.matches(regex)) {
            return true;
        }
        else {
            System.out.println("密码允许的字符为字母、数字、下划线，长度为8-16个字符");
            return false;
        }


    }
}
