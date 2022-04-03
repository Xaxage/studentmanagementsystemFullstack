package com.xaxage.studentmanagementsystem.controller;

import com.xaxage.studentmanagementsystem.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {
        return List.of(
                new Student(UUID.randomUUID(),
                        "Erik",
                        "Xaxagyan",
                        "xaxage@gmail.com",
                        Student.Gender.MAlE),
                new Student(UUID.randomUUID(),
                        "Monica",
                        "Belushi",
                        "Hot@gmail.com",
                        Student.Gender.FEMALE)
        );
    }
}
