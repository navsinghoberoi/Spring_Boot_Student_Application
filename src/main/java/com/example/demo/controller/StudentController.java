package com.example.demo.controller;

import com.example.demo.model.Student;
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
    public Student create(@RequestBody Student student) {
        return studentService.save(student);
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
