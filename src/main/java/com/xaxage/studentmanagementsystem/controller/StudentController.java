package com.xaxage.studentmanagementsystem.controller;

import com.xaxage.studentmanagementsystem.model.Student;
import com.xaxage.studentmanagementsystem.service.StudentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student student) {
        studentService.addNewStudent(student);
    }
}
