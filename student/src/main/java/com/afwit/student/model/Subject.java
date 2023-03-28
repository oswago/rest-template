package com.afwit.student.model;

import javax.persistence.*;
import lombok.Data;
import lombok.Generated;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "subject")
@Entity
public class Subject {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
    @Column(name = "name")
private String name;
}
