package com.example.schoolmanagementsystem.controller;


import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/add/cousre")
    public ResponseEntity<Course> addCourse (@RequestBody Course course) {
            return ResponseEntity.ok(courseService.addCourse(course));
    }
}
