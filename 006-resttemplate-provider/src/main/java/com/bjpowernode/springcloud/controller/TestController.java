package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.User;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping("/getForEntity01")
    public User test1(){
        return new User(1L,"Chloe",16);
    }

    @RequestMapping("/getForEntity02")
    public List<User> test(){
        List<User> userList = new ArrayList<User>();
        User user1 = new User(1L,"Chloe",16);
        User user2 = new User(2L,"Ezra",16);
        User user3 = new User(3L,"Adam",16);
        User user4 = new User(4L,"Luke",16);

        userList.addAll(Arrays.asList(user1,user2,user3,user4));
        return userList;
    }

    @RequestMapping("/getForEntityParam01")
    public User test03(User user){
        user.setUserName(user.getUserName()+ "服务提供者");
        return user;
    }

    @RequestMapping("/getForObj")
    public User getFOrObject(){
        User user = new User(1L,"Chloe",16);
        return user;
    }

    @RequestMapping("/postForObj")
    public User postForObject(User user){
        user.setUserName(user.getUserName()+ "服务提供者");
        return user;
    }

    @PutMapping("/put")
    public void put(User user){
        System.out.println(user.getId());
        System.out.println(user.getUserName());
        System.out.println(user.getAge());
    }

    @RequestMapping("/delete")
    public String delete(Integer id){
        System.out.println(id);
        return"删除成功";
    }
}
