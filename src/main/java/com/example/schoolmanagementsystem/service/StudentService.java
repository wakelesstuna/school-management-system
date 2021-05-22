package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.repository.CourseRepository;
import com.example.schoolmanagementsystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    private final CourseRepository courseRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        validateStudent(student);
        return studentRepository.save(student);
    }

    public String deleteStudent(UUID id) {
        String studentName = studentRepository.getOne(id).getName();

        studentRepository.findById(id)
                .ifPresentOrElse(studentRepository::delete, () -> {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "something went wrong");
                });

        return studentName + " är borttagen som student";
    }

    public String addStudentToCourse(UUID courseId, UUID studentId) {
        String studentName = studentRepository.getOne(studentId).getName();
        String courseName =  courseRepository.getOne(courseId).getName();

        courseRepository.findById(courseId)
                .ifPresent(course -> studentRepository.findById(studentId)
                        .ifPresent(student -> {
                            course.getStudents().add(student);
                            courseRepository.save(course);
                        }));

        return studentName + " började ta " + courseName;
    }

    private void validateStudent(Student student) {
        if (student.getName() == null || student.getName().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "student must have a name");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "student must have a email");
        }
        if (student.getAddress() == null || student.getAddress().isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "student must have a address");
        }
    }

}
