package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.InvalidNameException;
import javax.xml.bind.ValidationException;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {

}
