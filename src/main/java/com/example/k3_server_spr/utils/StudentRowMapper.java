package com.example.k3_server_spr.utils;

import com.example.k3_server_spr.entities.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String patronymic = rs.getString("patronymic");
        String status = rs.getString("status");
        long groupId = rs.getLong("groupId");
        return new Student(id, surname, name, patronymic, status, groupId);
    }
}
