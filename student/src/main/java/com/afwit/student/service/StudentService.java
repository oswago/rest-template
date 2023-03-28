package com.afwit.student.service;

import com.afwit.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface StudentService {
    public Optional<Student> getStudentByName(String name);
    public List <Student> getAll();
    Optional<Student> getById(int id);
    Student save(Student student);
}
