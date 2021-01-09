package com.bjpowernode.springboot.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjpowernode.springboot.mapper.UsersMapper;
import com.bjpowernode.springboot.model.User;
import com.bjpowernode.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class MainController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "login";
    }

    @PostMapping("/index")
    public String login(@RequestParam("username")String username,@RequestParam("password")String password){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        queryWrapper.select("username",username).select("password",password);
        int count = userService.count(queryWrapper);
        System.out.println(count);
        return String.valueOf(count);
    }
}
