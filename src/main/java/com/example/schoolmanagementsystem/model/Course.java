package com.example.schoolmanagementsystem.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Accessors(chain = true)
public class Course {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @OneToOne
    private Teacher teacher;

    @OneToMany
    private List<Lesson> lessons;
}
