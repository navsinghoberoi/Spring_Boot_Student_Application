package com.example.demo.controller;

import util.Student_Util;
import util.Constants;
import com.example.demo.model.Student;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController extends Student_Util {

    public StudentResponse response = new StudentResponse();
    @Autowired
    private StudentRepo studentService;

    @GetMapping("/getStudents")
    public StudentResponse read() {
        response.setMessage("Total no. of records found are => " + studentService.count());
        response.setExtraInfo(studentService.findAll());
        return response;
    }

    @GetMapping("/getStudentById/{id}")
    public StudentResponse readById(@PathVariable Integer id) {
        if (studentService.exists(id)) {
            success_case(response, Constants.SUCCESS_MESSAGE);
            response.setStudent(studentService.findOne(id));
        } else {
            failure_case(response, Constants.ID_NOT_EXISTS_FAILURE_MESSAGE);
            response.setStudent(null);
        }
        return response;
    }

    @PostMapping("/addStudent")
    public StudentResponse create(@RequestBody Student student) {
        if (student.getFirstName().trim().length() <= 2 || student.getLastName().trim().length() <= 2) {
            failure_case(response, Constants.NAME_LENGTH_FAILURE_MESSAGE);
        } else if (!student.getPhoneNumber().matches("[789]\\d{9}")) {
            failure_case(response, Constants.MOBILE_NUMBER_FAILURE_MESSAGE);
        } else {
            success_case(response, Constants.SUCCESS_MESSAGE);
            studentService.save(student);
        }
        return response;
    }

    @PutMapping("/updateStudent")
    public Student update(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("deleteStudent/{id}")
    public StudentResponse delete(@PathVariable Integer id) {
        if (studentService.exists(id)) {
            success_case(response, Constants.SUCCESS_MESSAGE);
            studentService.delete(id);
        } else {
            failure_case(response, Constants.ID_NOT_EXISTS_FAILURE_MESSAGE);
        }
        return response;
    }

}
