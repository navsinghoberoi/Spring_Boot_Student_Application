package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentService;

    @GetMapping("/getStudents")
    public Iterable<Student> read() {
        return studentService.findAll();
    }

    @PostMapping("/addStudent")
    public StudentResponse create(@RequestBody Student student) {
        StudentResponse response = new StudentResponse();
        if (student.getFirstName().trim().isEmpty() || student.getLastName().trim().isEmpty()) {
            response.setCode("BAD REQUEST");
            response.setMessage("Invalid request body; new student record not created");
        } else {
            System.out.println("In successful flow");
            response.setCode("OK");
            response.setMessage("New student record has been created");
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
