package com.example.k3_server_spr.repositories.jdbc;

import com.example.k3_server_spr.entities.StudentGroup;
import com.example.k3_server_spr.utils.CreateGroupPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.List;
import java.util.Objects;

@Repository
public class StudentGroupRepositoryJdbc {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<StudentGroup> groupRowMapper;

    @Autowired
    public StudentGroupRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.groupRowMapper = (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            return new StudentGroup(id, name);
        };
    }

    public long addStudentGroup(String name) {
        String sql = "insert into spr_studentGroup (name) values (?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = con -> {
            PreparedStatement preparedStatement = con.prepareStatement(sql, new String[]{"id"});
            preparedStatement.setString(1, name);
            return preparedStatement;
        };
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();
    }

    public StudentGroup getStudentGroupById(long id) {
        return jdbcTemplate.queryForObject(
                "select * from spr_studentGroup where id = ?",
                new Object[]{id},
                new int[]{Types.BIGINT},
                groupRowMapper);
    }

    public List<StudentGroup> getStudentGroups() {
        return jdbcTemplate.query("select * from spr_studentGroup", groupRowMapper, new Object[]{});
    }

    public void editStudentGroups(long id, String name) {
        jdbcTemplate.update(
                "update spr_studentGroup set name = ? where id = ?",
                new Object[]{name, id},
                new int[]{Types.VARCHAR, Types.BIGINT}
        );
    }

    public void deleteStudentGroupById(long id) {
        jdbcTemplate.update(
                "delete from spr_studentGroup where id = ?",
                new Object[]{id},
                new int[]{Types.BIGINT}
        );
    }
}
