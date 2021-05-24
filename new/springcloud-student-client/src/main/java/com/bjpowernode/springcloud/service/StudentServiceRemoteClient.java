package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-STUDENT-PROVIDER")
@RequestMapping("/student")
public interface StudentServiceRemoteClient {

    /**
     * 声明一个feign 接口，它的实现时服务提供者的controller实现
     * @param page
     * @param size
     * @return
     */
    @GetMapping(value = "/find/all")
    public Object findAllStudent(@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size);
}
