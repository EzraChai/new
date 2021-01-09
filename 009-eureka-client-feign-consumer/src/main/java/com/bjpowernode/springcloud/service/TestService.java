package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.hystrix.MyFallbackFactory;
import com.bjpowernode.springcloud.hystrix.myFallBack;
import com.bjpowernode.springcloud.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @FeignClient 用于标记当前接口是一个Feign声明式服务接口
 * Spring会为这个接口生成动态代理对象
 * 属性：用于指定注册中心某个服务的名字
 */
//@FeignClient(name = "009-EUREKA-CLIENT-FEIGN-PROVIDER",fallback = myFallBack.class )
@FeignClient(name = "009-EUREKA-CLIENT-FEIGN-PROVIDER",fallbackFactory = MyFallbackFactory.class  )
public interface TestService {

    //定义抽象方法要使用GetMapping
    @GetMapping("/test")
    String test();

    //必须要指定@RequestParam
    @GetMapping("/testParams01")
    String testParam(@RequestParam String name,@RequestParam Integer age);

    //必须使用@RequestBody Provider也一样
    @RequestMapping("/testParams02")
    String testParam02(@RequestBody User user);

    @RequestMapping("/testReturnUser")
    User testParam03();

    //使用List来接收响应数据
    @RequestMapping("/testReturnList")
    List<User> testReturnList();
}
