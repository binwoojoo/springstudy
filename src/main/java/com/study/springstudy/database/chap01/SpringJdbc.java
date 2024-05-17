package com.study.springstudy.database.chap01;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SpringJdbc {

    private final JdbcTemplate template;

    // INSERT
    public int save(Person person) {
        String sql = "INSERT INTO tbl_person VALUES (?,?,?)";
        return template.update(sql,
                person.getId(),
                person.getPersonName(),
                person.getPersonAge());
    }

    // DELETE
    public boolean delete(long id) {
        String sql = "DELETE FROM tbl_person WHERE id = ?";
        int result = template.update(sql, id);
        return result == 1;
    }

    // UPDATE
    public boolean update(Person newPerson) {
        // 이름,나이 수정
        String sql = "UPDATE tbl_person " +
                "SET person_name = ?," +
                "person_age = ?" +
                " WHERE id = ?";
        int result = template.update(sql,
                newPerson.getPersonName(),
                newPerson.getPersonAge(),
                newPerson.getId());
        return result == 1;
    }

    // SELECT: 다중행 조회
    public List<Person> findAll() {
        String sql = "SELECT * FROM tbl_person";

        List<Person> p = template.query(sql, (rs, rowNum) -> new Person(rs));

        return p;
    }

    // SELECT: 단일행 조회
    public Person findOne(long id) {
        String sql = "SELECT * FROM tbl_person WHERE id = ?";
        Person p = template.queryForObject(sql, (rs, n) -> new Person(rs), id);
        return p;
    }

//    // 내부 클래스
//    public static class PersonMapper implements RowMapper<Person>{
//
//        @Override
//        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//           return new Person(rs);
//
//        }
//    }

}
