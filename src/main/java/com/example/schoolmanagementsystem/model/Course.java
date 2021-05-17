package com.example.schoolmanagementsystem.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    private UUID id;

    private String courseName;

    @OneToMany
    private List<Lesson> lessons;
}
