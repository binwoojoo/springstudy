package com.study.springstudy.springmvc.chap04.repository;

import com.study.springstudy.springmvc.chap03.entity.Score;
import com.study.springstudy.springmvc.chap04.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardJdbcRepository implements BoardRepository {

    private final JdbcTemplate template;

    @Override
    public List<Board> findAll() {

        String sql = "SELECT * FROM tbl_board ";
        return template.query(sql, (rs, n) -> new Board(rs));

    }

    @Override
    public Board findOne(int boardNo) {
        String sql = "SELECT * FROM tbl_board WHERE board_no = ?";
        return template.queryForObject(sql, (rs, n) -> new Board(rs), boardNo);
    }

    @Override
    public boolean save(Board board) {
        String sql = "INSERT INTO tbl_board " +
                "(board_no, title, content, writer, view_count, reg_date_time) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return template.update(sql, board.getBoardNo(), board.getTitle()
                , board.getContent(), board.getWriter(), board.getViewCount()
                , board.getRegDateTime()) == 1;
    }

    @Override
    public boolean delete(int boardNo) {
        String sql = "DELETE FROM tbl_board WHERE board_no = ?";
        return template.update(sql, boardNo) == 1;
    }
}
