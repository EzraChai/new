package com.bjpowernode.springcloud.Exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String s) {
        super(s);
    }
}
