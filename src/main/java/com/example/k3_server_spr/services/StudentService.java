package com.example.k3_server_spr.services;

import com.example.k3_server_spr.entities.Student;
import com.example.k3_server_spr.repositories.jdbc.StudentGroupRepositoryJdbc;
import com.example.k3_server_spr.repositories.jdbc.StudentRepositoryJdbc;
import com.example.k3_server_spr.utils.CreateOrUpdateStudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepositoryJdbc studentRepositoryJdbc;

    public long addStudent(CreateOrUpdateStudentPojo pojo) {
        return studentRepositoryJdbc.addStudent(pojo);
    }

    public Student getStudentById(long id) {
        return studentRepositoryJdbc.getStudentById(id);
    }

    public List<Student> getStudents() {
        return studentRepositoryJdbc.getStudents();
    }

    public void editStudent(long id, CreateOrUpdateStudentPojo pojo) {
        studentRepositoryJdbc.editStudent(id, pojo);
    }

    public void deleteStudentById(long id) {
        studentRepositoryJdbc.deleteStudentById(id);
    }

}
