package com.xaxage.studentmanagementsystem.dao;

import com.xaxage.studentmanagementsystem.model.Student;
import com.xaxage.studentmanagementsystem.model.StudentCourse;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentDAO {
    List<Student> selectAllStudents();

    int insertStudent(UUID newStudentId, Student student);

    boolean isEmailTaken(String email);

    List<StudentCourse> selectAllStudentCourses(UUID studentId);
}
