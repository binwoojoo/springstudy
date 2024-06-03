package com.study.springstudy.springmvc.chap05.mapper;

import com.study.springstudy.springmvc.chap05.entity.Reaction;
import com.study.springstudy.springmvc.chap05.entity.ViewLog;
import org.apache.ibatis.annotations.Param;

public interface ReactionMapper {

    // 리액션 기록 추가 (Insert)
    void insertReaction(Reaction reaction);

    // 리액션 기록 시간 수정
    void updateReaction(Reaction reaction);

    // 조회수 기록 조회
    Reaction findOne(@Param("account") String account, @Param("bno") long bno);

}
