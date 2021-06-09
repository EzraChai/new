package com.bjpowernode.springcloud.service.implement;

import com.bjpowernode.springcloud.Exception.StudentNotFoundException;
import com.bjpowernode.springcloud.repository.StudentRepository;
import com.bjpowernode.springcloud.model.Student;
import com.bjpowernode.springcloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository jpaRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Page<Student> getAllStudent(Pageable pageable) {
        return jpaRepository.findAll(pageable);
    }


    @Override
    public Student getStudent(Long id) throws StudentNotFoundException {
        Optional<Student> student = jpaRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        throw new StudentNotFoundException("404 : Student with id [" + id + "] not found in our database");
    }

    @Override
    public Page<Student> getStudentByName(Pageable pageRequest,String name) {
        return jpaRepository.findAllByNameContainingIgnoreCase(pageRequest,name);
    }

    @Override
    public Page<Student> getStudentByRace(Pageable pageRequest,String race) {
        return jpaRepository.findAllByRaceContainingIgnoreCase(pageRequest,race);
    }

    @Override
    public Page<Student> getStudentByReligion(Pageable pageRequest,String religion) {
        return jpaRepository.findAllByReligionContainingIgnoreCase(pageRequest,religion);
    }

    @Override
    public Page<Student> getStudentByGender(Pageable pageRequest,String gender) {
        if (gender.equals("boy") || gender.equals("male")){
            return jpaRepository.findAllByGender(pageRequest,1);
        }else if (gender.equals("girl") || gender.equals("female")){
            return jpaRepository.findAllByGender(pageRequest,0);
        }
        return jpaRepository.findAllByGender(pageRequest,Integer.parseInt(gender));
    }
}
