package com.xaxage.studentmanagementsystem.service;

import com.xaxage.studentmanagementsystem.dao.StudentDAO;
import com.xaxage.studentmanagementsystem.exception.ApiRequestException;
import com.xaxage.studentmanagementsystem.model.Student;
import com.xaxage.studentmanagementsystem.model.StudentCourse;
import com.xaxage.studentmanagementsystem.validator.EmailValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;
    private final EmailValidator emailValidator;

    public StudentServiceImpl(StudentDAO studentDAO, EmailValidator emailValidator) {
        this.studentDAO = studentDAO;
        this.emailValidator = emailValidator;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.selectAllStudents();
    }

    @Override
    public void addNewStudent(Student student) {
        addNewStudent(null, student);
    }

    @Override
    public void addNewStudent(UUID studentId, Student student) {
        UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

        if (!emailValidator.test(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " is not valid");
        }

        if (studentDAO.isEmailTaken(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " already exists");
        }

        studentDAO.insertStudent(newStudentId, student);
    }

    @Override
    public List<StudentCourse> getAllCoursesForStudent(UUID studentId) {
        return studentDAO.selectAllStudentCourses(studentId);
    }
}
