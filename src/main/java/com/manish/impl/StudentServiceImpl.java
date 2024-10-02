package com.manish.impl;

import com.manish.entity.Student;
import com.manish.model.StudentDto;
import com.manish.repo.StudentRepo;
import com.manish.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo stuRepo;

    @Override
    public StudentDto createStudent(StudentDto stu) {

        Student student = new Student();
        BeanUtils.copyProperties(stu, student);

        Student saveEnt = stuRepo.save(student);

        StudentDto dto = new StudentDto();
        BeanUtils.copyProperties(stu, dto);
        return dto;
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> studentId = stuRepo.findById(id);
        return studentId.get();
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> stuRecords = stuRepo.findAll();
        List<StudentDto> viewRecords = new ArrayList<StudentDto>();
//        BeanUtils.copyProperties(stuRecords, viewRecords);
        for (Student stu: stuRecords) {
            StudentDto dto = new StudentDto();
//            dto.setFirstName(stu.getFirstName());
//            dto.setLastName(stu.getLastName());
//            dto.setEmail(stu.getEmail());
//            viewRecords.add(dto);
            BeanUtils.copyProperties(stu, dto);
            viewRecords.add(dto);

        }
        return viewRecords;
    }


    @Override
    public boolean deleteStudent(Long id) {

        boolean flag = false;

        Student studentId = stuRepo.findById(id).get();

        if (studentId != null) {
            stuRepo.deleteById(id);
            flag = true;
        }

        return flag;
    }

}
