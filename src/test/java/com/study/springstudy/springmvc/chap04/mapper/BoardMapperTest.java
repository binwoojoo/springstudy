package com.study.springstudy.springmvc.chap04.mapper;

import com.study.springstudy.springmvc.chap04.common.Page;
import com.study.springstudy.springmvc.chap05.mapper.ReplyMapper;
import com.study.springstudy.springmvc.chap05.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper mapper;
    ReplyMapper replyMapper;
    Page page;

    @Test
    @DisplayName("")
    void insertTest() {

//        for (int i = 1; i <= 100; i++) {
//            Board b = new Board();
//            b.setTitle("테스트 제목" + i);
//            b.setWriter("테스트 사람" + i);
//            b.setContent("테스트 내용" + i);
//            mapper.save(b);
//        }

    }

    @Test
    @DisplayName("")
    void reinsertTest() {

//        for (int i = 1; i <= 100; i++) {
//            Board b = new Board();
//            b.setTitle("테스트 제목" + i);
//            b.setWriter("테스트 사람" + i);
//            b.setContent("테스트 내용" + i);
//            mapper.save(b);
//        }

        for (int i = 1; i <= 5000; i++) {
            Reply reply = Reply.builder()
                    .replyText("하하호호댓글" + i)
                    .replyWriter("꾸러긔" + i)
                    .boardNo((long) (Math.random() * 100 + 1))
                    .build();

            replyMapper.save(reply);
        }
    }


}