package com.afwit.student.repository;

import com.afwit.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface StudentRepository extends JpaRepository<Student,Long> {
    Optional<Student> findByFirstName(String first_name);
}
