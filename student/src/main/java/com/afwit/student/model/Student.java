package com.afwit.student.model;

import javax.persistence.*;
import lombok.Data;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Data
@Table(name = "student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "grade")
    private int grade;
    @Column(name = "subject_id")
    private long subject_id;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private List <Subject> subject = new ArrayList <>();
}
