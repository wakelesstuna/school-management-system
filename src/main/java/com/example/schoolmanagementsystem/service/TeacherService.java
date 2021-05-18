package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Teacher;
import com.example.schoolmanagementsystem.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher addTeacher(Teacher teacher){
        validateTeacher(teacher);
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    public String deleteTeacher(UUID id) {

        String response = teacherRepository.findById(id).get().getName();

        teacherRepository.deleteById(id);

        return response + " har blivit borttagen";
    }

    private void validateTeacher(Teacher teacher) {
        if (teacherRepository.findByEmail(teacher.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "email already taken");
        }
    }
}
