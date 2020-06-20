package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.naming.InvalidNameException;
import javax.xml.bind.ValidationException;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
   /* @Override
    default Student save(Student student) {
        System.out.println("In modified save method");
        if (student.getFirstName().trim().length() == 0) {
            try {
                throw new InvalidNameException("First name of student cannot be blank");
            } catch (InvalidNameException e) {
                e.printStackTrace();
            }
        } else if (student.getLastName().trim().length() == 0) {
            try {
                throw new InvalidNameException("Last name of student cannot be blank");
            } catch (InvalidNameException e) {
                e.printStackTrace();
            }
        }else {

        }
        return student;
    }*/
}
