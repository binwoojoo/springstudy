package com.study.springstudy.springmvc.chap04.entity;

import com.study.springstudy.springmvc.chap03.entity.Grade;
import com.study.springstudy.springmvc.chap04.dto.BoardDto;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private int viewCount;
    private LocalDateTime regDateTime;

    public Board(ResultSet rs) throws SQLException {
        this.boardNo = rs.getInt("board_no");
        this.title = rs.getString("title");
        this.content = rs.getString("content");
        this.writer = rs.getString("writer");
        this.viewCount = rs.getInt("view_count");
        this.regDateTime = rs.getTimestamp("reg_date_time").toLocalDateTime();
    }

    public Board(BoardDto dto) {
        this.title = dto.getTitle();
        this.writer = dto.getWriter();
        this.content = dto.getContent();
        this.boardNo = getBoardNo();
        this.regDateTime = LocalDateTime.now();
        this.viewCount = getViewCount();
    }
}
