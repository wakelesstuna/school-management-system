package com.example.schoolmanagementsystem.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@Accessors(chain = true)
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

}
