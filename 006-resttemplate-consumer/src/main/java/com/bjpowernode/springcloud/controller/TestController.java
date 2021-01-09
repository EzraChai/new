package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test01")
    public String test01() {
        ResponseEntity<User> result = restTemplate.getForEntity("http://localhost:8081/getForEntity01", User.class);
        User body = result.getBody();
        return "User = " + body;
    }

    @RequestMapping("/test02")
    public String test02() {
        ResponseEntity<List> result = restTemplate.getForEntity("http://localhost:8081/getForEntity02", List.class);
        List body = result.getBody();
        return "User = " + body;
    }

    @RequestMapping("/test03")
    public String test03() {
        Object[]param = {1L,"Chloe",16};
        ResponseEntity<User> result = restTemplate.getForEntity("http://localhost:8081/getForEntityParam01?id={0}&userName={1}&age={2}", User.class,param);
        User body = result.getBody();
        return "User = " + body;
    }

    @RequestMapping("/test04")
    public String test04() {
        Map<String,Object>param = new HashMap<>();
        param.put("id",1L);
        param.put("userName","Chloe");
        param.put("age",16);

        ResponseEntity<User> result = restTemplate.getForEntity("http://localhost:8081/getForEntityParam01?id={id}&userName={userName}&age={age}", User.class,param);
        User body = result.getBody();
        return "User = " + body;
    }

    @RequestMapping("/getForObj")
    public String getForObject(){
        //getForObject == getForEntity 使用方式一致
        //区别在于getForObject是直接把服务提供者返回的数据以参数2 所指定的类型返回，不会返回ResponseEntity对象
        //如果不需要获取服务提供者响应的头文件信息以及状态编码时，完全可以使用 getForObject() 来替代 getForEntity()
        User user = restTemplate.getForObject("http://localhost:8081/getForObj",User.class);
        return "消费者----" + user;
    }

    @RequestMapping("/postForObj")
    public String postForObject(){
        //postForObject() == getForObject()
        //只是多了个request参数
        //User user1 = new User(2L,"Ezra",16);

        LinkedMultiValueMap params = new LinkedMultiValueMap();
        params.add("id",2L);
        params.add("userName","Ezra");
        params.add("age",19);

        User user = restTemplate.postForObject("http://localhost:8081/postForObj",params,User.class);
        return "User = "+user;
    }

    @RequestMapping("/put")
    public String put(){
        LinkedMultiValueMap param = new LinkedMultiValueMap();
        param.add("id",7L);
        param.add("userName","Arshim Long");
        param.add("age",16);
        restTemplate.put("http://localhost:8081/put",param);
        return "执行了put请求";
    }

    @RequestMapping("/delete")
    public String delete(){
        restTemplate.delete("http://localhost:8081/delete?id={id}",8L);
        return "执行了delete请求";
    }
}
