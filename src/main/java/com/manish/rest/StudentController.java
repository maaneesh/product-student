package com.manish.rest;

import com.manish.entity.Student;
import com.manish.impl.StudentServiceImpl;
import com.manish.model.StudentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    @Autowired
    private StudentServiceImpl serviceImpl;

    //Create Student REST Api
    @PostMapping("/stu")
    public ResponseEntity<?> saveStudent(@RequestBody StudentDto student) {
        StudentDto studentInfo = serviceImpl.createStudent(student);
        return new ResponseEntity<>(studentInfo, HttpStatus.CREATED);
    }

    //Build get all student info API
    @GetMapping(value="/view")
    public ResponseEntity<?> getStudents() {
        List<StudentDto> allStudents = serviceImpl.getAllStudents();
        return new ResponseEntity<>(allStudents, HttpStatus.OK);
    }

    //Build get Student by id API
    @GetMapping("/byId/{id}")
    public Student getStudentInfo(@PathVariable Long id){
        return serviceImpl.getStudentById(id);
    }
    //Delete item by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id){
        boolean deleteStudent = serviceImpl.deleteStudent(id);
        if (deleteStudent) {
            return new ResponseEntity<>("Student deleted", HttpStatus.OK);
            
        }else return new ResponseEntity<>("Student does not exist", HttpStatus.OK);

    }
}
