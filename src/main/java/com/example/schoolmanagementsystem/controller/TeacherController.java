package com.example.schoolmanagementsystem.controller;

import com.example.schoolmanagementsystem.model.Teacher;
import com.example.schoolmanagementsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher (@RequestBody Teacher teacher) {
        return ResponseEntity.ok(teacherService.addTeacher(teacher));
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteTeacher(@RequestParam UUID id) {
        return ResponseEntity.ok(teacherService.deleteTeacher(id));
    }
}
