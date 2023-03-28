package com.afwit.student.service;

import com.afwit.student.model.Subject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface SubjectService {
    public Optional <Subject> getSubjectByName(String name);
    public List <Subject> getAll();
    Optional<Subject> getById(int id);
    Subject save(Subject subject);
}
