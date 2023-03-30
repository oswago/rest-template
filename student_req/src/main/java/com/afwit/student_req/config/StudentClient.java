package com.afwit.student_req.config;

import com.afwit.student_req.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentClient {
    List <Student> getAllStudent();

    Student getById(Long id);

    HttpStatus addStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);
}
