package com.example.schoolmanagementsystem.service;

import com.example.schoolmanagementsystem.model.Course;
import com.example.schoolmanagementsystem.model.Lesson;
import com.example.schoolmanagementsystem.model.Student;
import com.example.schoolmanagementsystem.repository.CourseRepository;
import com.example.schoolmanagementsystem.repository.LessonRepository;
import com.example.schoolmanagementsystem.repository.StudentRepository;
import com.example.schoolmanagementsystem.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    private final TeacherRepository teacherRepository;

    private final LessonRepository lessonRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        validateCourse(course);
        return courseRepository.save(course);
    }

    public HttpStatus deleteCourse(UUID courseId) {
        if (validateCourseId(courseId)){
            courseRepository.deleteById(courseId);
            return HttpStatus.OK;
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no course with that id found");
    }




    public Course addTeacherToCourse(UUID courseId, String teacherEmail) {

        courseRepository.findById(courseId)
                .ifPresentOrElse(course -> teacherRepository.findByEmail(teacherEmail)
                        .ifPresentOrElse(teacher -> {
                            course.setTeacher(teacher);
                            courseRepository.save(course);
                        }, () -> {
                            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no teacher found");
                        }), () -> {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no course found");
                });

        return courseRepository.getOne(courseId);
    }

    public String addPresence(UUID courseId, UUID studentId) {

        Course course = courseRepository.getOne(courseId);
        Student student = studentRepository.getOne(studentId);

        lessonRepository.findByDate(LocalDate.now())
                .ifPresentOrElse(lesson -> {
                    lesson.getAttendingStudents().add(student);
                    lessonRepository.save(lesson);
                }, () -> {
                    Lesson newLesson = new Lesson();
                    newLesson.setDate(LocalDate.now());
                    newLesson.getAttendingStudents().add(student);
                    course.getLessons().add(lessonRepository.save(newLesson));
                    courseRepository.save(course);
                });

        return student.getName() + " gick på " + course.getName() + " den " + LocalDate.now();
    }

    private boolean validateCourseId(UUID courseId) {
        return courseRepository.findById(courseId).isPresent();
    }

    private void validateCourse(Course course){
        if (course.getName() == null || course.getName().isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "teacher must have a name");
        }
    }

}
