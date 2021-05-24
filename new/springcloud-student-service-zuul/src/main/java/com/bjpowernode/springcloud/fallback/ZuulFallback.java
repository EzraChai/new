package com.bjpowernode.springcloud.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Zuul 服务降级
 *
 * @return
 */
@Component
public class ZuulFallback implements FallbackProvider {

    @Override
    public String getRoute() {
        //所有服务都降级
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.BAD_REQUEST.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.BAD_GATEWAY.getReasonPhrase();
            }

            @Override
            public void close() {
                //关闭了流，可以做一些清理的动作
            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(("{\"message\":\"Opps... The server had down, please try again later\"}").getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };

    }
}
