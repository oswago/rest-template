package com.afwit.student.service;

import com.afwit.student.model.Student;
import com.afwit.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Optional<Student> getStudentByName(String name) {
        Optional <Student> student = studentRepository.findByFirstName(name);
        return Optional.ofNullable(student.orElse(null));
    }
    @Override
    public List <Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional <Student> getById(int id) {
        Optional<Student> student=studentRepository.findById(Long.valueOf(id));
        return Optional.ofNullable(student.orElse(null));
    }

    @Override
    public Student save(Student student) {
       Student bol = studentRepository.save(student);
      return bol;
    }

}
