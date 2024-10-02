package com.manish.service;

import com.manish.entity.Student;
import com.manish.model.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto stu);
    Student getStudentById(Long id);
    List<StudentDto> getAllStudents();
    boolean deleteStudent(Long id);
}
