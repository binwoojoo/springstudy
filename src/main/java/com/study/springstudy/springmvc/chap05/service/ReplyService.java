package com.study.springstudy.springmvc.chap05.service;

import com.study.springstudy.springmvc.chap05.dto.request.ReplyPostDto;
import com.study.springstudy.springmvc.chap05.dto.response.ReplyDetailDto;
import com.study.springstudy.springmvc.chap05.entity.Reply;
import com.study.springstudy.springmvc.chap05.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyService {

    private final ReplyMapper replyMapper;

    // 댓글 목록 전체 조회
    public List<ReplyDetailDto> getReplies(long boardNo) {

        List<Reply> replies = replyMapper.findAll(boardNo);

        return replies.stream()
                .map(reply -> new ReplyDetailDto(reply))
                .collect(Collectors.toList());
    }

    // 댓글 입력
    public boolean register(ReplyPostDto dto) {

        Reply reply = Reply.builder()
                .replyText(dto.getText())
                .replyWriter(dto.getAuthor())
                .boardNo(dto.getBno())
                .build();

        boolean flag = replyMapper.save(reply);

        if (flag) {
            log.info("등록 성공");
        } else {
            log.info("등록 실패");
        }

        return flag;
    }

    // 댓글 수정
    public void modify() {

    }

    // 댓글 삭제
    public void remove() {

    }
}