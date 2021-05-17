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
public class Student {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String address;
    private String email;
    private String zipcode;
    private String city;
    private String phoneNumber;

    @OneToMany
    private List<Course> courses;

}
