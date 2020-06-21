package com.example.demo.controller;

import com.example.demo.Constants;
import com.example.demo.model.Student;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentResponse response = new StudentResponse();
    @Autowired
    private StudentRepo studentService;

    @GetMapping("/getStudents")
    public Iterable<Student> read() {
        return studentService.findAll();
    }

    @GetMapping("/getStudentById/{id}")
    public StudentResponse readStudentId(@PathVariable Integer id) {
        if (studentService.exists(id)) {
            response.setCode(Constants.SUCCESS_CODE);
            response.setMessage(Constants.SUCCESS_MESSAGE);
            response.setStudent(studentService.findOne(id));
        } else {
            response.setCode(Constants.FAILURE_CODE);
            response.setMessage(Constants.FAILURE_MESSAGE);
        }
        return response;
    }


    @PostMapping("/addStudent")
    public StudentResponse create(@RequestBody Student student) {
        if (student.getFirstName().trim().isEmpty() || student.getLastName().trim().isEmpty()) {
            response.setCode(Constants.FAILURE_CODE);
            response.setMessage(Constants.FAILURE_MESSAGE);
        } else {
            response.setCode(Constants.SUCCESS_CODE);
            response.setMessage(Constants.SUCCESS_MESSAGE);
        }
        studentService.save(student);
        return response;
    }

    @PutMapping("/updateStudent")
    public Student update(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("deleteStudent/{id}")
    public void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }

}
