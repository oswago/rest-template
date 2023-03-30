package com.afwit.student_req.config;

import com.afwit.student_req.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentClientImpl implements StudentClient {

    @Autowired
    RestTemplate restTemplate;
    final String ROOT_URI = "http://localhost:8080/api/student";
    @Override
    public List <Student> getAllStudent() {
        ResponseEntity<Student[]> response=restTemplate.getForEntity(ROOT_URI+"/all",Student[].class);
        return Arrays.asList(response.getBody());
    }

    @Override
    public Student getById(Long id) {
        ResponseEntity<Student> response=restTemplate.getForEntity(ROOT_URI+"/"+id,Student.class);
        return response.getBody();
    }

    @Override
    public HttpStatus addStudent(Student student) {
        ResponseEntity<HttpStatus> response=restTemplate.postForEntity(ROOT_URI+"/",student, HttpStatus.class);
        return response.getBody();
    }

    @Override
    public void updateStudent(Student student) {
        restTemplate.put(ROOT_URI, student);
    }

    @Override
    public void deleteStudent(Long id) {
        restTemplate.delete(ROOT_URI + id);
    }

}
