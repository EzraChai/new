package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceRemoteClientFallback implements StudentServiceRemoteClient {
    @Override
    public Object findAllStudent(int page, int size) {
        return new Student();
    }

    @Override
    public Student findStudentById(int id) {
        return new Student();
    }

    @Override
    public Object findStudentByStudentName(String name, int page, int size) {
        return new Student();
    }

    @Override
    public Object findStudentByRace(String race, int page, int size) {
        return new Student();
    }

    @Override
    public Object findStudentByReligion(String religion, int page, int size) {
        return new Student();
    }

    @Override
    public Object findStudentByGender(String gender, int page, int size) {
        return new Student();
    }
}
