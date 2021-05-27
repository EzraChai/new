package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "${service.id}", /*fallback = StudentServiceRemoteClientFallback.class*/
        fallbackFactory = StudentServiceRemoteClientFallbackFactory.class)
public interface StudentServiceRemoteClient {

    @GetMapping(value = "/student/find/all")
    public Object findAllStudent(@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size);

    @GetMapping(value = "/student/find/id/{id}")
    public Student findStudentById(@PathVariable("id") int id);

    @GetMapping(value = "/student/find/name/{student-name}")
    public Object findStudentByStudentName(@PathVariable("student-name") String name, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size);

    @GetMapping(value = "/student/find/race/{race}")
    public Object findStudentByRace(@PathVariable("race") String race, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size);

    @GetMapping(value = "/student/find/religion/{religion}")
    public Object findStudentByReligion(@PathVariable("religion") String religion, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size);

    @GetMapping(value = "/student/find/gender/{gender}")
    public Object findStudentByGender(@PathVariable("gender") String gender, @RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size);

    @GetMapping("/student/get/config")
    public String getConfig();
}
