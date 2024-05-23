package com.study.springstudy.springmvc.chap05;

import com.study.springstudy.springmvc.chap04.mapper.BoardMapper;
import com.study.springstudy.springmvc.chap05.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    BoardMapper boardMapper;
    @Autowired
    ReplyMapper replyMapper;

    @Test
    @DisplayName("전체 조회")
    void findAllTest() {
        //given
        long boardNo = 1;
        //when
        List<Reply> replyList = replyMapper.findAll(boardNo);
        //then
        replyList.forEach(System.out::println);
    }

    @Test
    @DisplayName("댓글 삭제")
    void deleteTest() {
        //given
        long replyNo = 1;
        //when
        boolean flag = replyMapper.delete(replyNo);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("수정")
    void modifyTest() {
        //given
        long replyNo = 2;
        Reply reply = Reply.builder()
                .replyNo(replyNo)
                .replyText("수정수정")
                .build();
        //when
        replyMapper.modify(reply);
        //then
    }

}