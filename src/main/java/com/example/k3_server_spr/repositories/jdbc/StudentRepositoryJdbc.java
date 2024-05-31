package com.example.k3_server_spr.repositories.jdbc;

import com.example.k3_server_spr.entities.Student;
import com.example.k3_server_spr.utils.CreateOrUpdateStudentPojo;
import com.example.k3_server_spr.utils.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;


@Repository
public class StudentRepositoryJdbc {
    private final JdbcTemplate jdbcTemplate;
    private final StudentRowMapper studentRowMapper;

    @Autowired
    public StudentRepositoryJdbc(JdbcTemplate jdbcTemplate, StudentRowMapper studentRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentRowMapper = studentRowMapper;
    }

    public Long addStudent(CreateOrUpdateStudentPojo pojo) {
        String sql = "insert into spr_student (name, surname,  status, groupId, patronymic) values (?, ?, ?, ?, ?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, pojo.getName());
            preparedStatement.setString(2, pojo.getSurname());
            preparedStatement.setString(5, pojo.getPatronymic());
            preparedStatement.setString(3, String.valueOf(pojo.getStatus()));
            preparedStatement.setLong(4, pojo.getGroupId());
            return preparedStatement;
        };
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();
    }

    public Student getStudentById(long id) {
            return jdbcTemplate.queryForObject(
                    "select * from spr_student where id = ?",
                    new Object[]{id},
                    new int[]{Types.BIGINT},
                    studentRowMapper);

    }

    public List<Student> getStudents() {
        return jdbcTemplate.query("select * from spr_student", studentRowMapper, new Object[]{});
    }

    public void deleteStudentById(long id) {
        jdbcTemplate.update(
                "delete from spr_student where id = ?",
                new Object[]{id},
                new int[]{Types.BIGINT}
        );
    }

    public void editStudent(long id, CreateOrUpdateStudentPojo pojo) {
        jdbcTemplate.update(
                "update spr_student set name = ?, surname = ?, status = ?, groupId = ?, patronymic = ?  where id = ?",
                new Object[]{pojo.getName(), pojo.getSurname(), pojo.getStatus(), pojo.getGroupId(), pojo.getPatronymic(), id},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.BIGINT, Types.VARCHAR,  Types.BIGINT}
        );
    }


}
