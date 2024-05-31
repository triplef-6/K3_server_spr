package com.example.k3_server_spr.controllers;

import com.example.k3_server_spr.entities.StudentGroup;
import com.example.k3_server_spr.services.StudentGroupService;
import com.example.k3_server_spr.utils.CreateGroupPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentGroupController {
    @Autowired
    private StudentGroupService studentGroupService;

    @PostMapping("/studentGroups")
    public ResponseEntity<Long> addStudentGroups(@RequestBody CreateGroupPojo pojo) {
        return new ResponseEntity<>(studentGroupService.addStudentGroups(pojo.getName()), HttpStatus.CREATED);
    }

    @PutMapping("/studentGroups/{id}")
    public ResponseEntity editStudentGroups(@PathVariable("id") long id, @RequestBody CreateGroupPojo name) {
        studentGroupService.editStudentGroups(id, name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/studentGroups/{id}")
    public ResponseEntity deleteStudentGroup(@PathVariable("id") long id) {
        studentGroupService.deleteStudentGroup(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/studentGroups")
    public ResponseEntity<List<StudentGroup>> getStudentGroups() {
        return new ResponseEntity<>(studentGroupService.getStudentGroups(), HttpStatus.OK);
    }

    @GetMapping("/studentGroups/{id}")
    public ResponseEntity<StudentGroup> getStudentGroupById(@PathVariable("id") long id) {
        return new ResponseEntity<>(studentGroupService.getStudentGroupById(id), HttpStatus.OK);
    }
}
