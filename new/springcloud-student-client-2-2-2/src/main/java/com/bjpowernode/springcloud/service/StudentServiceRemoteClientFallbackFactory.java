package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.model.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceRemoteClientFallbackFactory implements FallbackFactory<StudentServiceRemoteClient> {
    @Override
    public StudentServiceRemoteClient create(Throwable throwable) {
        return new StudentServiceRemoteClient() {
            @Override
            public Object findAllStudent(int page, int size) {
                String message = throwable.getMessage();
                System.out.println("message = " + message);
                return new Student();
            }

            @Override
            public Student findStudentById(int id) {
                String message = throwable.getMessage();
                System.out.println("message = " + message);
                return new Student();
            }

            @Override
            public Object findStudentByStudentName(String name, int page, int size) {
                String message = throwable.getMessage();
                System.out.println("message = " + message);
                return new Student();
            }

            @Override
            public Object findStudentByRace(String race, int page, int size) {
                String message = throwable.getMessage();
                System.out.println("message = " + message);
                return new Student();
            }

            @Override
            public Object findStudentByReligion(String religion, int page, int size) {
                String message = throwable.getMessage();
                System.out.println("message = " + message);
                return new Student();
            }

            @Override
            public Object findStudentByGender(String gender, int page, int size) {
                String message = throwable.getMessage();
                System.out.println("message = " + message);
                return new Student();
            }

            @Override
            public String getConfig() {
                return null;
            }
        };
    }
}
