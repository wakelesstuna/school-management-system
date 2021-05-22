package com.example.schoolmanagementsystem.controller;


import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.model.Teacher;
import com.example.schoolmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent (@RequestBody Student student) {
        return ResponseEntity.ok(studentService.addStudent(student));
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam UUID id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @GetMapping("/add/course")
    public ResponseEntity<String> addStudentToCourse(@RequestParam UUID courseId,
                                                     @RequestParam UUID studentId) {
        return ResponseEntity.ok(studentService.addStudentToCourse(courseId,studentId));
    }

}
