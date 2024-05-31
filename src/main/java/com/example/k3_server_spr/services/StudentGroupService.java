package com.example.k3_server_spr.services;

import com.example.k3_server_spr.entities.StudentGroup;
import com.example.k3_server_spr.repositories.jdbc.StudentGroupRepositoryJdbc;
import com.example.k3_server_spr.utils.CreateGroupPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentGroupService {

    @Autowired
    private StudentGroupRepositoryJdbc studentGroupRepositoryJdbc;

    public long addStudentGroups(String studentGroup) {
        return studentGroupRepositoryJdbc.addStudentGroup(studentGroup);
    }

    public StudentGroup getStudentGroupById(long id) {
        return studentGroupRepositoryJdbc.getStudentGroupById(id);
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroupRepositoryJdbc.getStudentGroups();
    }

    public void editStudentGroups(long id, CreateGroupPojo user) {
        studentGroupRepositoryJdbc.editStudentGroups(id, user.getName());
    }

    public void deleteStudentGroup(long id) {
        studentGroupRepositoryJdbc.deleteStudentGroupById(id);
    }
}
