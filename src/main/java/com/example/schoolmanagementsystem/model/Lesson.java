package com.example.schoolmanagementsystem.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Lesson {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDate date;

    @OneToMany
    private List<Student> attendingStudents;

}
