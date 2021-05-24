package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PersonController {

    @RequestMapping("/cloud/get-person")
    public Person getPerson(){
        Person p1 = new Person();
        p1.setId(UUID.randomUUID().toString());
        p1.setName("Chloe Gan");
        p1.setGender(0);
        p1.setAge(16);

        return p1;
    }
}
