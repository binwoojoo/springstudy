package com.study.springstudy.springmvc.chap04.mapper;

import com.study.springstudy.springmvc.chap04.common.Page;
import com.study.springstudy.springmvc.chap04.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper mapper;
    Page page;

    @Test
    @DisplayName("")
    void insertTest() {

        for (int i = 300; i < 306; i++) {
            Board b = new Board();
            b.setTitle("테스트 제목" + i);
            b.setWriter("테스트 사람" + i);
            b.setContent("테스트 내용" + i);
            mapper.save(b);
        }
    }

}