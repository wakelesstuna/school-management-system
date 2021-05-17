package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LessonRepository extends JpaRepository<Lesson, UUID> {
}
