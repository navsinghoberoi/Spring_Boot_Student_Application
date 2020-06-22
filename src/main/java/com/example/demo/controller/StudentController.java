package com.example.demo.controller;

import util.StudentUtil;
import util.Constants;
import com.example.demo.model.Student;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
@RequestMapping("/student")
public class StudentController extends StudentUtil {

    public static final StudentResponse response = new StudentResponse();

    @Autowired
    private StudentRepo studentService;

    @GetMapping("/getAll")
    public StudentResponse read() {
        response.setMessage("Total no. of records found are => " + studentService.count());
        response.setExtraInfo(studentService.findAll());
        return response;
    }

    @GetMapping("/getById/{id}")
    public StudentResponse readById(@PathVariable Integer id) {
        if (studentService.exists(id)) {
            successCase(response, Constants.SUCCESS_MESSAGE);
            response.setStudent(studentService.findOne(id));
            response.setExtraInfo(null);
        } else {
            failureCase(response, Constants.ID_NOT_EXISTS_FAILURE_MESSAGE);
            response.setStudent(null);
            response.setExtraInfo(null);
        }
        return response;
    }

    @GetMapping("/getByNumber/{phoneNumber}")
    public StudentResponse readByPhoneNumber(@PathVariable String phoneNumber) {
        Iterator<Student> studentList = studentService.findAll().iterator();
        while (studentList.hasNext()) {
            Student student = studentList.next();
            //    System.out.println("Student data in iteration => " + student.getPhoneNumber());
            if (!student.getPhoneNumber().equals(phoneNumber)) {
                failureCase(response, Constants.PHONE_NUMBER_NOT_EXISTS_FAILURE_MESSAGE);
                response.setStudent(null);
                response.setExtraInfo(null);
            } else if (student.getPhoneNumber().equals(phoneNumber)) {
                successCase(response, Constants.SUCCESS_MESSAGE);
                response.setStudent(student);
                response.setExtraInfo(null);
                return response;
            }
        }
        return response;
    }

    @PostMapping("/add")
    public StudentResponse create(@RequestBody Student student) {
        if (student.getFirstName().trim().length() <= 2 || student.getLastName().trim().length() <= 2) {
            failureCase(response, Constants.NAME_LENGTH_FAILURE_MESSAGE);
        } else if (!student.getPhoneNumber().matches("[789]\\d{9}")) {
            failureCase(response, Constants.MOBILE_NUMBER_FAILURE_MESSAGE);
        } else {
            successCase(response, Constants.SUCCESS_MESSAGE);
            studentService.save(student);
        }
        return response;
    }

    @PutMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("delete/{id}")
    public StudentResponse delete(@PathVariable Integer id) {
        if (studentService.exists(id)) {
            successCase(response, Constants.SUCCESS_MESSAGE);
            studentService.delete(id);
        } else {
            failureCase(response, Constants.ID_NOT_EXISTS_FAILURE_MESSAGE);
        }
        return response;
    }

}
