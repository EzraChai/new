package com.bjpowernode.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogFilter extends ZuulFilter {

    /**
     * 在路由的时候执行
     *
     * @return void
     */
    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    /**
     * 执行的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER;
    }

    /**
     * 是否过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //true == 使用过滤器, false == 不使用过滤器
        return true;
    }

    /**
     * 在路由的时候执行run方法
     *
     * @return null
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        String URI = httpServletRequest.getRequestURI();
        int port = httpServletRequest.getRemotePort();
        String remoteAddr = httpServletRequest.getRemoteAddr();
        System.out.println("Request address: " + remoteAddr + ":" + port + URI);

        //返回值 null 目前没有任何意义
        return null;
    }
}
