package com.bjpowernode.springcloud.repository;

import com.bjpowernode.springcloud.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
    Page<Student> findAllByNameContainingIgnoreCase(Pageable pageRequest, String name);

    Page<Student> findAllByRaceContainingIgnoreCase(Pageable pageRequest,String race);

    Page<Student> findAllByReligionContainingIgnoreCase(Pageable pageRequest,String religion);

    Page<Student> findAllByGender(Pageable pageRequest,int num);
}
