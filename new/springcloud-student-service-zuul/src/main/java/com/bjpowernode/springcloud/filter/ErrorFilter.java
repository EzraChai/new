package com.bjpowernode.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.DEBUG_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        try {
            RequestContext requestContext = RequestContext.getCurrentContext();
            ZuulException exception = (ZuulException) requestContext.getThrowable();
            System.out.println("Exception message: " + exception.getMessage());
            HttpServletResponse response = requestContext.getResponse();
            response.setStatus(exception.nStatusCode);
            response.setContentType("application/json; charset=utf-8");
            PrintWriter printWriter = null;
            try {
                printWriter = response.getWriter();
                printWriter.print("{code:" + exception.nStatusCode + ",message:\"" + exception.getMessage() + "\"}");
            } catch (IOException e) {
                ReflectionUtils.rethrowRuntimeException(e);
            } finally {
                if (printWriter != null) {
                    printWriter.close();
                }
            }
        } catch (Exception e) {
            ReflectionUtils.rethrowRuntimeException(e);
        }
        return null;
    }
}
