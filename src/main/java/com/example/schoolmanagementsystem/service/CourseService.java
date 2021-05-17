package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
