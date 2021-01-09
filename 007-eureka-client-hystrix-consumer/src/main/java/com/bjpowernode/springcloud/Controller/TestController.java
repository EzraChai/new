package com.bjpowernode.springcloud.Controller;

import com.bjpowernode.springcloud.hystrix.MyHytrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 标记当前控制器启用Hystrix的熔点机制当我们调用远程服务时出现异常或超时就会自动进行熔断
     * 属性：fallbackMethod用于指定一个方法的名称
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/test")
    public String test(){
        String body = restTemplate.getForObject("http://007-EUREKA-CLIENT-HYSTRIX-PROVIDER/test",String.class);
        return "带有Hystrix的服务消费者--- " + body;
    }

    /**
     * commandProperties用于设置熔断器的一些属性
     * @HystrixProperty 熔断器的属性
     * execution.isolation.thread.timeoutInMilliseconds 熔断器的超时时间，默认为1000ms === 1秒
     * value 属性的值
     * @return
     */
    @HystrixCommand(fallbackMethod = "error",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")
    })
    @RequestMapping("/test02")
    public String test02(){
        String body = restTemplate.getForObject("http://007-EUREKA-CLIENT-HYSTRIX-PROVIDER/test02",String.class);
        return "带有Hystrix的服务消费者--- " + body;
    }

    /**
     * 属性
     *ignoreExceptions  用于指定熔断时忽略某些异常
     * @return
     */
    @HystrixCommand(fallbackMethod = "error",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")},
            ignoreExceptions = {ArithmeticException.class}
    )
    @RequestMapping("/test03")
    public String test03(){
        String str = null;
        System.out.println(str.length());
        String body = restTemplate.getForObject("http://007-EUREKA-CLIENT-HYSTRIX-PROVIDER/test03",String.class);
        return "带有Hystrix的服务消费者--- " + body;
    }

    /**
     *
     * @param throwable 只要被监控的控制器方法出现异常，自动会被熔断  异常对象
     *                  被Spring注入异常对象
     * @return
     */
    public String error(Throwable throwable){
        System.out.println(throwable.getClass());
        System.out.println(throwable.getMessage());
        return "服务被熔断了";
    }

    @RequestMapping("/test04")
    public String test04(){
        MyHytrixCommand cmd = new MyHytrixCommand(com.netflix.hystrix.HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("")),restTemplate,"http://007-EUREKA-CLIENT-HYSTRIX-PROVIDER/test04");
        String body = (String) cmd.execute();
        return "带有Hystrix的自定义服务消费者---" + body;
    }

}
