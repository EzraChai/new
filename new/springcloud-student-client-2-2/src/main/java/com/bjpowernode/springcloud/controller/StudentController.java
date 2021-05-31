package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.Student;
import com.bjpowernode.springcloud.service.StudentServiceRemoteClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RefreshScope
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {


    private final StudentServiceRemoteClient remoteClient;

    @Autowired
    public StudentController(@Qualifier("com.bjpowernode.springcloud.service.StudentServiceRemoteClient") StudentServiceRemoteClient remoteClient) {
        this.remoteClient = remoteClient;
    }

    @HystrixCommand
    @GetMapping("/feign/find/all")
    public Object getAllStudentFeign(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (size != null && page != null) {
            return remoteClient.findAllStudent(page, size);
        } else {
            return remoteClient.findAllStudent(0, 35);
        }
    }

    /*@HystrixCommand(fallbackMethod = "fallback",
            threadPoolKey = "chloegan",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "2"),
                    @HystrixProperty(name = "maxQueueSize", value = "1")
            }
    )*/
    @HystrixCommand
    @GetMapping("/feign/find/id/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        System.out.println("Running");
        return remoteClient.findStudentById(id);
    }

    /**
     * 降级方法
     * 备用方法
     *
     * @return 默认结果
     */
//    public Student fallback(@PathVariable("id") int id, Throwable throwable){
//        System.out.println(throwable.getMessage());
//        return new Student((long) id,"Not Found",404,"Not Found","Not Found");
//    }
    @HystrixCommand
    @GetMapping("/feign/find/name/{name}")
    public Object getStudentNames(@PathVariable("name") String name, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (size != null && page != null) {
            return remoteClient.findStudentByStudentName(name, page, size);
        } else {
            return remoteClient.findStudentByStudentName(name, 0, 10);
        }
    }

    @HystrixCommand
    @GetMapping("/feign/find/race/{race}")
    public Object getStudentRace(@PathVariable("race") String race, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (size != null && page != null) {
            return remoteClient.findStudentByRace(race, page, size);
        } else {
            return remoteClient.findStudentByRace(race, 0, 10);
        }
    }

    @GetMapping("/feign/find/religion/{religion}")
    public Object getStudentReligion(@PathVariable("religion") String religion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (size != null && page != null) {
            return remoteClient.findStudentByReligion(religion, page, size);
        } else {
            return remoteClient.findStudentByReligion(religion, 0, 10);
        }
    }

    @HystrixCommand
    @GetMapping("/feign/find/gender/{gender}")
    public Object getStudentGender(@PathVariable("gender") String gender, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        if (size != null && page != null) {
            return remoteClient.findStudentByGender(gender, page, size);
        } else {
            return remoteClient.findStudentByGender(gender, 0, 10);
        }
    }

    /**
     * 读取配置文件里的配置
     *
     * @return password
     */
    @GetMapping("/feign/get/config")
    public String getConfig() {
        String config = remoteClient.getConfig();
        return config;
    }
}
