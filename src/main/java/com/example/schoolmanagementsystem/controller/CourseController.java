package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<List<Course>> allCourses() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        return ResponseEntity.ok(courseService.addCourse(course));
    }

    @GetMapping("/delete")
    public ResponseEntity<HttpStatus> deleteCourse(@RequestParam UUID courseId){
        return ResponseEntity.ok(courseService.deleteCourse(courseId));
    }

    @GetMapping("/add/teacher")
    public ResponseEntity<Course> addTeacherToCourse(@RequestParam UUID courseId,
                                                     @RequestParam String teacherEmail) {
        return ResponseEntity.ok(courseService.addTeacherToCourse(courseId,teacherEmail));
    }

}
