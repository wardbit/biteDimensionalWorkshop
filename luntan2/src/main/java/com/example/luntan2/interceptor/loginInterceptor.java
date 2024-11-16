package com.example.luntan2.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.luntan2.entity.User;
import com.example.luntan2.mapper.UserMapper;
//import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@MapperScan("com.example.luntan2.mapper")
@Tag(name="注册拦截器")
@RestController
@Tag(name="注册拦截器")
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
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Invalid username or password");
            response.getWriter().flush();
            return false; // 阻止请求继续处理
        }
    }

    private boolean isValidUsername(String username) {
        String regex = "^[a-zA-Z]\\w{4,15}$";
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = userMapper.selectOne(queryWrapper.eq("username", username));
        if (user != null) {
            System.out.println("Username already exists");
            return false;
        }
        return username.matches(regex);
    }

    private boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*\\W).{8,}$";
        if (password.matches(regex)) {
            return true;
        } else {
            System.out.println("密码必须至少包含一个大写字母、一个小写字母、一个数字、一个特殊字符，长度至少8个字符");
            return false;
        }
    }
}


