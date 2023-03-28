package com.afwit.student.controller;

import com.afwit.student.model.ResponseMessage;
import com.afwit.student.model.Student;
import com.afwit.student.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")

public class StudentController {
    @Autowired
    StudentServiceImpl studentService;
    @GetMapping("/all")
    public ResponseEntity <List <Student>> findAll(){
       List<Student> student=studentService.getAll();
       return ResponseEntity.ok().body(student);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        Optional<Student> optionalStudent= studentService.getById(id);
        if(optionalStudent.isPresent()){
            return ResponseEntity.ok().body(optionalStudent.get());
        }else{
           //return ResponseEntity.notFound().build();
            return ResponseEntity.ok().build();
        }

    }
    @PostMapping("/")
    public ResponseEntity<ResponseMessage> save(@RequestBody Student student){
        Student student1=studentService.save(student);
        if(student1.getId()>=1){
            return ResponseEntity.ok().body(new ResponseMessage(200,"Success"));
        }else{
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(300,"Failed"));
        }

    }

}
