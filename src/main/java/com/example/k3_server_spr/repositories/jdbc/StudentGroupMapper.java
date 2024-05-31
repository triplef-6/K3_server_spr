package com.example.k3_server_spr.repositories.jdbc;

import com.example.k3_server_spr.entities.StudentGroup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentGroupMapper implements RowMapper<StudentGroup> {

    @Override
    public StudentGroup mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setId(resultSet.getInt("id"));
        studentGroup.setName(resultSet.getString("name"));
        return studentGroup;
    }
}
