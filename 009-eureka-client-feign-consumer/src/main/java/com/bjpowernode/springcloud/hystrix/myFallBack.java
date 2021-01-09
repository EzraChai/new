package com.bjpowernode.springcloud.hystrix;

import com.bjpowernode.springcloud.model.User;
import com.bjpowernode.springcloud.service.TestService;
import org.springframework.stereotype.Component;

import java.util.List;

//自定义异常熔断器
@Component
public class myFallBack implements TestService {
    @Override
    public String test() {
        return "test 请求熔断";
    }

    @Override
    public String testParam(String name, Integer age) {
        return "testParam 请求熔断";
    }

    @Override
    public String testParam02(User user) {
        return "testParam02 请求熔断";
    }

    @Override
    public User testParam03() {
        return null;
    }

    @Override
    public List<User> testReturnList() {
        return null;
    }
}
