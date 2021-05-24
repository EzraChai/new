package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> getAllStudent(Pageable pageable);
    Student getStudent(Long id) throws Exception;
    Page<Student> getStudentByName(Pageable pageable,String name);
    Page<Student> getStudentByRace(Pageable pageable,String race);
    Page<Student> getStudentByReligion(Pageable pageable,String religion);
    Page<Student> getStudentByGender(Pageable pageable,String gender);

}
