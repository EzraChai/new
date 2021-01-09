package com.bjpowernode.sprincloud.web;

import com.bjpowernode.sprincloud.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @GetMapping("/test")
    public String test(){
        System.out.println(10/0);
        return "使用Feign的服务提供者";
    }

    @GetMapping("/testParams01")
    public String testParam(String name,Integer age){
        return "testParams01使用Feign的服务提供者 Name: " + name +" Age: "+ age ;
    }

    @RequestMapping("/testParams02")
    public String testParam02(@RequestBody User user){
        return "testParams02使用Feign的服务提供者 Name: " + user.getName() +" Age: "+ user.getAge() ;
    }

    @RequestMapping("/testReturnUser")
    public Object testReturnUser(){
        return new User("Chloe",16);
    }

    @RequestMapping("/testReturnList")
    public List<User> testReturnList(){
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("Chloe",16));
        list.add(new User("Ezra",16));
        list.add(new User("Yi Jin",24));
        return list;
    }
}
