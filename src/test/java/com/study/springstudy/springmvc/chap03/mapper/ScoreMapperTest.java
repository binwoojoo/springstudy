package com.study.springstudy.springmvc.chap03.mapper;

import com.study.springstudy.springmvc.chap03.dto.RankDto;
import com.study.springstudy.springmvc.chap03.entity.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("전체 조회")
    void findAllTest() {
        //given

        //when
        List<Score> scoreList = mapper.findAll(null);
        //then
        scoreList.forEach(System.out::println);
    }

    @Test
    @DisplayName("개별 조회")
    void findOneTest() {
        //given
        long stuNum = 4;
        //when
        Score s = mapper.findOne(stuNum);
        //then
        System.out.println("s = " + s);
    }

    @Test
    @DisplayName("순위 조회")
    void findRankByStuNumTest() {
        //given
        long stuNum = 4;
        //when
        RankDto rankByStuNum = mapper.findRankByStuNum(stuNum);
        //then
        System.out.println("rankByStuNum = " + rankByStuNum);
    }

}