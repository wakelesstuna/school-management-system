package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
