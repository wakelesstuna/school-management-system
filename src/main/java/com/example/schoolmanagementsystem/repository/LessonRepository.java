package com.example.schoolmanagementsystem.repository;

import com.example.schoolmanagementsystem.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, UUID> {

    Optional<Lesson> findByDate(LocalDate localDate);
}
