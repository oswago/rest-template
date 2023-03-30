package com.afwit.student_req.model;

import lombok.Data;

@Data
public class Student {
    private long id;
    private String firstName;
    private String lastname;
    private int grade;
    private long subject_id;
}
