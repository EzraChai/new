package com.bjpowernode.springcloud.controller;

import com.bjpowernode.springcloud.model.Student;
import com.bjpowernode.springcloud.service.implement.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentServiceImpl studentServiceImpl;

    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }


    @GetMapping(value = "/find/all")
    public Page<Student> findAllStudent(@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return studentServiceImpl.getAllStudent(pageRequest);
    }

    @GetMapping("/find/id/{id}")
    public Student findStudentById(@PathVariable("id") int id) {
            return studentServiceImpl.getStudent(Long.valueof(id));
    }

    @GetMapping(value = "/find/name/{student-name}")
    public Page<Student> findStudentByStudentName(@PathVariable("student-name") String name,@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return studentServiceImpl.getStudentByName(pageRequest,name.toLowerCase());
    }

    @GetMapping(value = "/find/race/{race}")
    public Page<Student> findStudentByRace(@PathVariable("race") String race,@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return studentServiceImpl.getStudentByRace(pageRequest,race.toLowerCase());
    }

    @GetMapping(value = "/find/religion/{religion}")
    public Page<Student> findStudentByReligion(@PathVariable("religion") String religion,@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return studentServiceImpl.getStudentByReligion(pageRequest,religion.toLowerCase());
    }

    @GetMapping(value = "/find/gender/{gender}")
    public Page<Student> findStudentByGender(@PathVariable("gender") String gender,@RequestParam(value = "page", required = false, defaultValue = "0") int page, @RequestParam(value = "size", required = false, defaultValue = "36") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return studentServiceImpl.getStudentByGender(pageRequest,gender.trim().toLowerCase());
    }
}
