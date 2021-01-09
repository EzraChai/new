package com.bjpowernode.springcloud.web;

import com.bjpowernode.springcloud.model.User;
import com.bjpowernode.springcloud.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MyController {
    @Resource
    private TestService testService;

    @GetMapping("/test")
    public String test() {
        String result = testService.test();
        return "使用Feign服务的消费者" + result;
    }

    @GetMapping("/testParams")
    public String testParam() {
        String result = testService.testParam("Chloe", 16);
        return "使用Feign服务的消费者" + result;
    }

    @GetMapping("/testParams02")
    public String testParam02() {
        String result = testService.testParam02(new User("Ezra", 16));
        return "Params02使用Feign服务的消费者" + result;
    }

    @GetMapping("/testReturnUser")
    public String testUserReturn() {
        User result = testService.testParam03();
        return "Name = " + result.getName() + " Age = " + result.getAge();
    }

    @GetMapping("/testReturnList")
    public String testUserList() {
        List<User> result = testService.testReturnList();
        for (User user : result) {
            System.out.println("name = " + user.getName() + "  age = " + user.getAge());
        }
        return " " + result;
    }
}
