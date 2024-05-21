package com.study.springstudy.springmvc.chap04.controller;

import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.mapper.BoardMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BoardControllerTest {

    BoardMapper mapper;

    @Test
    @DisplayName("리스트 전체조회")
    void listTest() {
        //given
        List<Board> boardList = mapper.findAll();
        //when

        //then
        System.out.println("boardList = " + boardList);
    }

}