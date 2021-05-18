package com.example.schoolmanagementsystem.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@Accessors(chain = true)
public class Teacher {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String phoneNumber;

    private String email;

}
