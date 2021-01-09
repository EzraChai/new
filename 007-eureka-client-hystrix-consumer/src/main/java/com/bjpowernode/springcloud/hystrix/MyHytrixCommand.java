package com.bjpowernode.springcloud.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

//自定义异常熔断器
public class MyHytrixCommand extends HystrixCommand {

    private RestTemplate restTemplate;
    private String url;

    /**
     * 定义有参构造(必须)
     *
     * @param setter
     */
    public MyHytrixCommand(Setter setter, RestTemplate restTemplate, String url) {
        super(setter);
        this.restTemplate = restTemplate;
        this.url = url;
    }

    /**
     * 不能手动调用
     * @return
     * @throws Exception
     */
    @Override
    protected Object run() throws Exception {
        return restTemplate.getForObject(url,String.class);
    }

    /**
     * 服务降级方法
     * @return
     */
    @Override
    protected Object getFallback() {
        System.out.println(super.getFailedExecutionException().getClass());
        System.out.println(super.getFailedExecutionException().getMessage());
        return "自定义异常熔断器断了服务";
    }
}
