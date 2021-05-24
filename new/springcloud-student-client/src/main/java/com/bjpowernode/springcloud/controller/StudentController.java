package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.Student;
import com.bjpowernode.springcloud.service.StudentServiceRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final RestTemplate restTemplate;

    @Autowired
    public StudentController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    //注册中心（服务名）
    private final String PROVIDER_URL = "http://SERVICE-STUDENT-PROVIDER/student";


    //feign的远程调用客户端
    @Autowired
    private StudentServiceRemoteClient remoteClient;

    @GetMapping("/feign/find/all")
    public Object getAllStudentFeign(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size){
        if (size != null && page != null) {
            return remoteClient.findAllStudent(page,size);
        }else{
            return remoteClient.findAllStudent(0,35);
        }
    }

    @GetMapping(value = "/find/all")
    public Object getAllStudent(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        ResponseEntity<Object> studentList;
        if (size != null && page != null) {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/all?page=" + page + "&size=" + size, Object.class);
        } else {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/all", Object.class);
        }
        return studentList.getBody();
    }

    @GetMapping("/find/id/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        ResponseEntity<Student> student = restTemplate.getForEntity(PROVIDER_URL + "/find/id/" + id, Student.class);
        return student.getBody();
    }

    @GetMapping("/find/name/{name}")
    public Object getStudentNames(@PathVariable("name") String name, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        ResponseEntity<Object> studentList;
        if (size != null && page != null) {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/name/" + name + "?page=" + page + "&size=" + size, Object.class);
        } else {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/name/" + name, Object.class);
        }
        return studentList.getBody();
    }

    @GetMapping("/find/race/{race}")
    public Object getStudentRace(@PathVariable("race") String race, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        ResponseEntity<Object> studentList;
        if (size != null && page != null) {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/race/" + race + "?page=" + page + "&size=" + size, Object.class);
        } else {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/race/" + race, Object.class);
        }
        return studentList.getBody();
    }

    @GetMapping("/find/religion/{religion}")
    public Object getStudentReligion(@PathVariable("religion") String religion, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        ResponseEntity<Object> studentList;
        if (size != null && page != null) {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/religion/" + religion + "?page=" + page + "&size=" + size, Object.class);
        } else {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/religion/" + religion, Object.class);
        }
        return studentList.getBody();
    }

    @GetMapping("/find/gender/{gender}")
    public Object getStudentGender(@PathVariable("gender") String gender, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size) {
        ResponseEntity<Object> studentList;
        if (size != null && page != null) {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/gender/" + gender + "?page=" + page + "&size=" + size, Object.class);
        } else {
            studentList = restTemplate.getForEntity(PROVIDER_URL + "/find/gender/" + gender, Object.class);
        }
        return studentList.getBody();
    }
}
