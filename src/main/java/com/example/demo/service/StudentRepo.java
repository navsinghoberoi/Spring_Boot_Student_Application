package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.bind.ValidationException;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
  /*  @Override
    default <S extends Student> S save(S s) {
        System.out.println("In default save method");
        return s;
    }*/
}
