package com.study.springstudy.springmvc.chap04.service;

import com.study.springstudy.springmvc.chap04.common.Search;
import com.study.springstudy.springmvc.chap04.dto.BoardDetailResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardListResponseDto;
import com.study.springstudy.springmvc.chap04.dto.BoardWriteRequestDto;
import com.study.springstudy.springmvc.chap04.entity.Board;
import com.study.springstudy.springmvc.chap04.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    // 목록 조회 중간처리
    public List<BoardListResponseDto> findAll(Search page) {
        List<Board> boardList = mapper.findAll(page);

        // 조회해온 게시물 리스트에서 각 게시물들의 조회수를 확인하여
        // 조회수가 5이상인 게시물에 특정 마킹
        List<BoardListResponseDto> bList = boardList.stream()
                .map(b -> new BoardListResponseDto(b))
                .collect(Collectors.toList());

        return bList;
    }

    // 등록 요청 중간처리
    public void save(BoardWriteRequestDto dto) {

        Board b = dto.toEntity();

       mapper.save(b);

    }

    public void delete(int bno) {
        mapper.delete(bno);
    }

    public BoardDetailResponseDto findOne(int bno) {
        Board board = mapper.findOne(bno);
        if (board != null) mapper.viewCount(bno);
        return new BoardDetailResponseDto(board);
    }

    public int getCount(Search page) {
        return mapper.getCount(page);
    }

}
