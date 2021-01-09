package com.bjpowernode.springcloud.hystrix;

import com.bjpowernode.springcloud.model.User;
import com.bjpowernode.springcloud.service.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


//自定义异常容器类
@Component
public class MyFallbackFactory implements FallbackFactory<TestService> {
    @Override
    public TestService create(Throwable throwable) {
        return new TestService() {
            @Override
            public String test() {
                return "test 请求熔断" + throwable.getMessage();
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
        };
    }
}
