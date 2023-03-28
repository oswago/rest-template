package com.afwit.student.controller;

import com.afwit.student.model.ResponseMessage;
import com.afwit.student.model.Subject;
import com.afwit.student.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @GetMapping("/all")
    public ResponseEntity<List<Subject>> findAll(){
        List<Subject> subjects=subjectRepository.findAll();
        return ResponseEntity.ok().body(subjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(value = "id") int id){
        Optional<Subject> subjectOptional=subjectRepository.findById(Long.valueOf(id));
        if(subjectOptional.isPresent()){
            return ResponseEntity.ok().body(subjectOptional);
        }else{
            return ResponseEntity.ok().body("No data Found");
        }
    }

    @PostMapping("/")
    public ResponseEntity<ResponseMessage> save(@RequestBody Subject subject){
      Subject subject1=subjectRepository.save(subject);
      if(subject1.getId()>=1){
          return ResponseEntity.ok().body(new ResponseMessage(200,"Success"));
      }
      else{
          return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(300,"Failed"));
      }
    }
}
