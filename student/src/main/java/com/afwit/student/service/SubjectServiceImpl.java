package com.afwit.student.service;

import com.afwit.student.model.Subject;
import com.afwit.student.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;
    @Override
    public Optional <Subject> getSubjectByName(String name) {
        Optional<Subject> subject=subjectRepository.findByName(name);
        return Optional.ofNullable(subject.orElse(null));
    }

    @Override
    public List <Subject> getAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional <Subject> getById(int id) {
       Optional<Subject> subject=subjectRepository.findById((long) id);
       return Optional.ofNullable(subject.orElse(null));
    }

    @Override
    public Subject save(Subject subject) {
        Subject sub=subjectRepository.save(subject);
        return sub;
    }
}
