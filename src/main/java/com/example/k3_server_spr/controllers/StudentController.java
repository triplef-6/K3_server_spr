package com.example.k3_server_spr.controllers;

import com.example.k3_server_spr.entities.Student;
import com.example.k3_server_spr.services.StudentService;
import com.example.k3_server_spr.utils.CreateOrUpdateStudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<Long> addStudent(@RequestBody CreateOrUpdateStudentPojo pojo) {
        return new ResponseEntity<>(studentService.addStudent(pojo), HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> editStudent(@PathVariable("id") long id,
                                               @RequestBody CreateOrUpdateStudentPojo pojo) {
        studentService.editStudent(id, pojo);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudentById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }
}
