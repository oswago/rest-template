package com.afwit.student_req.controller;

import com.afwit.student_req.config.StudentClient;
import com.afwit.student_req.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/data")
@RestController
public class ConsumeWebService {
    @Autowired
   StudentClient client;
    @GetMapping("/student")
    public List <Student> getAll(){
        for(Student stud: client.getAllStudent()){
            System.out.println("Name:"+stud.getFirstName());
        }
        return client.getAllStudent();
    }
}
