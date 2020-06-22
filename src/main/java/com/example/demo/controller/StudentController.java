package com.example.demo.controller;

import util.Student_Util;
import util.Constants;
import com.example.demo.model.Student;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController extends Student_Util {

    public StudentResponse response = new StudentResponse();
    @Autowired
    private StudentRepo studentService;

    @GetMapping("/getStudents")
    public StudentResponse read() {
        response.setMessage("Total no. of records found are =>" + studentService.count());
        response.setExtraInfo(studentService.findAll());
        return response;
    }

    @GetMapping("/getStudentById/{id}")
    public StudentResponse readById(@PathVariable Integer id) {
        if (studentService.exists(id)) {
            success_case(response);
            response.setStudent(studentService.findOne(id));
        } else {
            failure_case(response);
        }
        return response;
    }

    @PostMapping("/addStudent")
    public StudentResponse create(@RequestBody Student student) {
        if (student.getFirstName().trim().isEmpty() || student.getLastName().trim().isEmpty()) {
            failure_case(response);
        } else {
            success_case(response);
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
            success_case(response);
            studentService.delete(id);
        } else {
            failure_case(response);
        }
        return response;
    }

}
