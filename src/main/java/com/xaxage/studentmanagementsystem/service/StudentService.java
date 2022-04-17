package com.xaxage.studentmanagementsystem.service;

import com.xaxage.studentmanagementsystem.model.Student;
import com.xaxage.studentmanagementsystem.model.StudentCourse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface StudentService {

    List<Student> getAllStudents();

    void addNewStudent(Student student);

    void addNewStudent(UUID studentId, Student student);

    List<StudentCourse> getAllCoursesForStudent(UUID studentId);
}
