package com.bjpowernode.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthFilter02 extends ZuulFilter {

    //执行时机
    @Override
    public String filterType() {
        //返回pre 表示当前过滤器为前置过滤器
        return "pre";
    }

    //过滤器的序号,返回值大小决定执行的先后顺序
    @Override
    public int filterOrder() {
        return 1;
    }

    //true启动当前过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体执行方法
    @Override
    public Object run() throws ZuulException {
        System.out.println("");
        //获取当前请求上下文对象
        RequestContext context = RequestContext.getCurrentContext();

        //获取用户请求对象
        HttpServletRequest request = context.getRequest();

        //获取请求中的请求参数Token(身份令牌：验证请求身份是否合法)
        String token = request.getParameter("token");

        //验证身份
        if (token == null || !"123".equals(token)) {

            //设定false表示请求不继续执行
            context.setSendZuulResponse(false);
            //设置响应编码为401表示权限不足
            context.setResponseStatusCode(401);
            //设置响应类型以及编码格式
            context.addZuulResponseHeader("content-type", "text/html:charset=utf-8");
            //设置响应内容
            context.setResponseBody("非法请求");
        } else {
            System.out.println("请求合法");
        }
        return null;
    }
}
