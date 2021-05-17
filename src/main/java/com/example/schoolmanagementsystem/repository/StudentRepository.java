package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
}
