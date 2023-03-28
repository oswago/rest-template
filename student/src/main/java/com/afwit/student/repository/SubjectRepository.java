package com.afwit.student.repository;

import com.afwit.student.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Optional <Subject> findByName(String name);
}
